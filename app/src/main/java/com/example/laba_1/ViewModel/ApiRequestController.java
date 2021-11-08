package com.example.laba_1.ViewModel;

import android.util.Log;
import android.widget.Toast;

import com.example.laba_1.Interfaces.Authorization.IApiRequest;
import com.example.laba_1.dto.TestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequestController implements Callback<TestResponse> {
    private static String baseUrl= "";
    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IApiRequest apiRequest = retrofit.create(IApiRequest.class);

        Call<TestResponse> call = apiRequest.getUserState();
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {
        if (response.isSuccessful())
        {
            if (response.body() != null) {
                Log.i("Succsess", response.body().name);
            }
        }
    }

    @Override
    public void onFailure(Call<TestResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
