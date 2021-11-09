package com.example.laba_1.ViewModel;

import android.util.Log;

import com.example.laba_1.Interfaces.Authorization.IApiRequest;
import com.example.laba_1.dto.Book;
import com.example.laba_1.dto.TestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequestController implements Callback<List<Book>> {
    private static String baseUrl= "https://raw.githubusercontent.com";
    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IApiRequest apiRequest = retrofit.create(IApiRequest.class);

        Call<List<Book>> call = apiRequest.getListOfBooks();
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
        if (response.isSuccessful())
        {
            if (response.body() != null) {
                for (Book book:
                     response.body()) {
                    Log.i("Book", "\n\n"+book.Author + "\n"+book.Genre + "\n"+book.Name + "\n"+book.PublicationDate );
                }
            }
        }
    }

    @Override
    public void onFailure(Call<List<Book>> call, Throwable t) {
        t.printStackTrace();
    }
}
