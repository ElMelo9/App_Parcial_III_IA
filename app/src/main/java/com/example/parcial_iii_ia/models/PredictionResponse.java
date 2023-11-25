package com.example.parcial_iii_ia.models;

public class PredictionResponse {

    private String air_quality;
    private String water_pollution;

    public PredictionResponse() {

    }

    public String getAir_quality() {
        return air_quality;
    }

    public void setAir_quality(String air_quality) {
        this.air_quality = air_quality;
    }

    public String getWater_pollution() {
        return water_pollution;
    }

    public void setWater_pollution(String water_pollution) {
        this.water_pollution = water_pollution;
    }

    @Override
    public String toString() {
        return "Prediccion: "+"\nCalidad del aire: "+getAir_quality()+"\nPolucion en el agua: "+getWater_pollution();
    }
}
