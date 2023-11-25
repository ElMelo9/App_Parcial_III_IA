package com.example.parcial_iii_ia.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial_iii_ia.R;
import com.example.parcial_iii_ia.controllers.LoginController;
import com.example.parcial_iii_ia.interfaces.ResultListener;
import com.example.parcial_iii_ia.models.TokenResponse;

public class MainActivity extends AppCompatActivity implements ResultListener<TokenResponse> {

    private EditText emailEditText;
    private EditText passwordEditText;

    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        findViewById(R.id.loginButton).setOnClickListener(v -> login());
    }
    private void login() {

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Por favor, ingrese su correo y contraseña", Toast.LENGTH_LONG).show();

        }else {

            this.loginController = new LoginController();
            loginController.login(email, password,this);

        }

            }


    @Override
    public void onSuccess(TokenResponse response) {
        String token = response.getToken();
        Intent intent = new Intent(this, FormPredictionActivity.class);
        intent.putExtra("token", token);
        startActivity(intent);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
