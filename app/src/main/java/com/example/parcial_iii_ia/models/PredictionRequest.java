package com.example.parcial_iii_ia.models;

public class PredictionRequest {
    private String city;
    private String region;
    private String country;
    private String air_quality;
    private String water_pollution;

    public PredictionRequest(String city, String region, String country, String air_quality, String water_pollution) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.air_quality = air_quality;
        this.water_pollution = water_pollution;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
