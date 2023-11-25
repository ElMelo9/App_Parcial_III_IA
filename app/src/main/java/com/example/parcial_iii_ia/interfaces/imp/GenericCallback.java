package com.example.parcial_iii_ia.interfaces.imp;

import com.example.parcial_iii_ia.interfaces.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenericCallback<T> implements Callback<T> {
    private ResultListener<T> resultListener;

    public GenericCallback(ResultListener<T> resultListener) {
        this.resultListener = resultListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            resultListener.onSuccess(response.body());
        } else {
            resultListener.onFailure("Error: " + response.message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        resultListener.onFailure("Failure: " + t.getMessage());
    }
}