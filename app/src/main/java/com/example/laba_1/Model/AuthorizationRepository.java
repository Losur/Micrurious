package com.example.laba_1.Model;

import androidx.annotation.Nullable;

import com.example.laba_1.Interfaces.Authorization.IAuthorizationRepository;
import com.example.laba_1.dto.User;

import java.util.ArrayList;
import java.util.List;

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

        return user;
    }
}