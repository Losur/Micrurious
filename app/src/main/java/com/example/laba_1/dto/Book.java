package com.example.laba_1.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("Author")
    @Expose
    public String Author;

    @SerializedName("Genre")
    @Expose
    public String Genre;

    @SerializedName("Name")
    @Expose
    public String Name;

    @SerializedName("PublicationDate")
    @Expose
    public String PublicationDate;
}
