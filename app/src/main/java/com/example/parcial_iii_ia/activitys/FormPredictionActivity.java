package com.example.parcial_iii_ia.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial_iii_ia.R;
import com.example.parcial_iii_ia.controllers.PredictionController;
import com.example.parcial_iii_ia.interfaces.ResultListener;
import com.example.parcial_iii_ia.models.PredictionResponse;

public class FormPredictionActivity extends AppCompatActivity implements ResultListener<PredictionResponse> {

    private EditText editTextCity;
    private EditText editTextRegion;
    private EditText editTextCountry;
    private EditText editTextAirQuality;
    private EditText editTextWaterPollution;
    private PredictionController predictionController;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_prediction);

        editTextCity = findViewById(R.id.editTextCity);
        editTextRegion = findViewById(R.id.editTextRegion);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextAirQuality = findViewById(R.id.editTextAirQuality);
        editTextWaterPollution = findViewById(R.id.editTextWaterPollution);

        this.token = getIntent().getStringExtra("token");

        // Verifica que el token no sea null
        if (token == null) {
            Toast.makeText(this, "No se proporcionó token.", Toast.LENGTH_SHORT).show();
            finish(); // Termina la Activity si no hay token
            return;
        }

        findViewById(R.id.buttonSubmit).setOnClickListener(v -> submitForm());

    }

    private void submitForm() {

        String city = editTextCity.getText().toString();
        String region = editTextRegion.getText().toString();
        String country = editTextCountry.getText().toString();
        String airQuality = editTextAirQuality.getText().toString();
        String waterPollution = editTextWaterPollution.getText().toString();

        if (city.isEmpty() || region.isEmpty() || country.isEmpty() || airQuality.isEmpty() || waterPollution.isEmpty()){
            Toast.makeText(this, "Por favor, ingrese todos los datos", Toast.LENGTH_LONG).show();
        }else{
            this.predictionController = new PredictionController(this.token);
            this.predictionController.predictionWithData(city, region, country, airQuality, waterPollution, this);
        }

    }
    @Override
    public void onSuccess(PredictionResponse responseBody) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado de la Predicción");
        builder.setMessage(responseBody.toString());
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}