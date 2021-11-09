package com.example.laba_1.Interfaces.Authorization;

import com.example.laba_1.dto.Book;
import com.example.laba_1.dto.TestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiRequest {
    @GET("/Lpirskaya/JsonLab/master/Books1.json")
    Call<List<Book>> getListOfBooks();
}
