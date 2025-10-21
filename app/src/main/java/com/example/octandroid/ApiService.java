package com.example.octandroid;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login/v2/getOtp")
    Call<LoginResponse> crateUser(@Body JsonObject jsonObject);
}
