package com.example.laba_1.Interfaces.Authorization;

import com.example.laba_1.dto.User;

public interface IAuthorizationRepository {
    public User authorizeUser(String email, String password );
}
