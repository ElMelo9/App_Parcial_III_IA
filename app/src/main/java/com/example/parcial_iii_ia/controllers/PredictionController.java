package com.example.parcial_iii_ia.controllers;

import com.example.parcial_iii_ia.interfaces.AuthService;
import com.example.parcial_iii_ia.interfaces.PredictionService;
import com.example.parcial_iii_ia.interfaces.ResultListener;
import com.example.parcial_iii_ia.models.PredictionRequest;
import com.example.parcial_iii_ia.models.PredictionResponse;
import com.example.parcial_iii_ia.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PredictionController {

    private Retrofit retrofit;

    private PredictionService predictionService;

    private PredictionRequest predictionRequest;
    private String token;


    public PredictionController(String token) {
        this.token = token;

        this.retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.predictionService = retrofit.create(PredictionService.class);
    }


    public void predictionWithData(String city, String region, String country, String waterPollution, String airQuality, ResultListener listener){

        this.predictionRequest = new PredictionRequest(city,region,country,airQuality,waterPollution);

        Call<PredictionResponse> call = predictionService.prediction("Bearer " + this.token,this.predictionRequest);

        call.enqueue(new Callback<PredictionResponse>() {
            @Override
            public void onResponse(Call<PredictionResponse> call, Response<PredictionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PredictionResponse predictionResponse= response.body();

                    listener.onSuccess(predictionResponse);
                } else {
                    listener.onFailure("Inicio de sesión fallido.");
                }
            }

            @Override
            public void onFailure(Call<PredictionResponse> call, Throwable t) {
                listener.onFailure("Error de conexión: " + t.getMessage());
            }
        });

    }


}
