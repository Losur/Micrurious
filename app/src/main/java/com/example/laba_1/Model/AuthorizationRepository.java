package com.example.laba_1.Model;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.laba_1.Interfaces.Authorization.IAuthorizationRepository;
import com.example.laba_1.dto.TestResponse;
import com.example.laba_1.dto.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationRepository implements IAuthorizationRepository {
    private static String apiUrl= "https://whatsnew.7pace.com/api/authorization/get-user-state";
    private final List<User> users = new ArrayList<User>(){
        {
            add(new User(){
                {
                    id = java.util.UUID.randomUUID().toString();
                    email = "test@test.ru";
                    password = "test";
                };
            });
            add(new User(){
                {
                    id = java.util.UUID.randomUUID().toString();
                    email = "1@1.1";
                    password = "1";
                };
            });
            add(new User(){
                {
                    id = java.util.UUID.randomUUID().toString();
                    email = "yaroslav@test.ru";
                    password = "yaroslav";
                };
            });
        }
    };

    @Override
    public User authorizeUser(String email, String password) {
        User user = null;
        for (User u: users) {
            if (u.email.equals(email) && u.password.equals(password)) {
                user = u;
                break;
            }
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        StringBuilder response = new StringBuilder();
                        BufferedReader input = new BufferedReader(new InputStreamReader
                                (connection.getInputStream()), 8192);
                        String line = null;
                        while ((line = input.readLine()) != null)
                        {
                            response.append(line);
                        }
                        input.close();

                        Gson gson = new Gson();
                        TestResponse r = gson.fromJson(response.toString(), TestResponse.class);
                        if (r.isAuthenticated) {
                            Log.i("Hello`", email);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

        return user;
    }
}