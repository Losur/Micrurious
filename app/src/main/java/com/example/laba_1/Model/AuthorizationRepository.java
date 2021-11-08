package com.example.laba_1.Model;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.laba_1.Interfaces.Authorization.IApiRequest;
import com.example.laba_1.Interfaces.Authorization.IAuthorizationRepository;
import com.example.laba_1.ViewModel.ApiRequestController;
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

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthorizationRepository implements IAuthorizationRepository {

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
        ApiRequestController controller = new ApiRequestController();
        controller.start();
        return user;
    }
}