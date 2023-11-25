package com.example.parcial_iii_ia.controllers;

import com.example.parcial_iii_ia.interfaces.AuthService;
import com.example.parcial_iii_ia.interfaces.ResultListener;
import com.example.parcial_iii_ia.models.LoginRequest;
import com.example.parcial_iii_ia.models.TokenResponse;
import com.example.parcial_iii_ia.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


import retrofit2.Retrofit;

public class LoginController {

    private Retrofit retrofit;
    private AuthService authService;
   private LoginRequest loginRequest;


    public LoginController() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.authService = retrofit.create(AuthService.class);


    }

    public void login(String email, String password, ResultListener listener){

        this.loginRequest = new LoginRequest(email, password);

        Call<TokenResponse> call = authService.login(loginRequest);

        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TokenResponse tokenResponse = response.body();
                    // Aquí manejas el token recibido
                    String token = tokenResponse.getToken();
                    System.out.println("token: " + token);
                    listener.onSuccess(tokenResponse);
                } else {
                    listener.onFailure("Inicio de sesión fallido.");
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                listener.onFailure("Error de conexión: " + t.getMessage());
            }
        });

    }


}
