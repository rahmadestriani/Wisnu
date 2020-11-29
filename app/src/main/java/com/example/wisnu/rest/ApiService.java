package com.example.wisnu.rest;

import com.example.wisnu.model.RootPariwisataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta/wisata") //endpoint
    Call<RootPariwisataModel> getData();
}