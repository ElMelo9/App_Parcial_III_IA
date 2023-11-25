package com.example.parcial_iii_ia.interfaces;

import com.example.parcial_iii_ia.models.LoginRequest;
import com.example.parcial_iii_ia.models.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("login")
    Call<TokenResponse> login(@Body LoginRequest loginRequest);

}
