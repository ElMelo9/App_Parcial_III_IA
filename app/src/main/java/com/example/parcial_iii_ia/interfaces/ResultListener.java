package com.example.parcial_iii_ia.interfaces;

public interface ResultListener<T> {

    void onSuccess(T responseBody);
    void onFailure(String error);

}
