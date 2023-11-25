package com.example.parcial_iii_ia.interfaces;

import com.example.parcial_iii_ia.models.LoginRequest;
import com.example.parcial_iii_ia.models.PredictionRequest;
import com.example.parcial_iii_ia.models.PredictionResponse;
import com.example.parcial_iii_ia.models.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PredictionService {
    @POST("crear_dato")
    Call<PredictionResponse> prediction(@Header("Authorization") String authToken, @Body PredictionRequest predictionRequest);
}
