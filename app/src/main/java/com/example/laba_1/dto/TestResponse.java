package com.example.laba_1.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestResponse {
    @SerializedName("auth")
    @Expose
    public boolean isAuthenticated;

    @SerializedName("name")
    @Expose
    public String name;

}
