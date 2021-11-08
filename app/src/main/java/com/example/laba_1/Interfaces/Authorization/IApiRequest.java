package com.example.laba_1.Interfaces.Authorization;

import com.example.laba_1.dto.TestResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiRequest {
    @GET("sample")
    Call<TestResponse> getUserState();
}
