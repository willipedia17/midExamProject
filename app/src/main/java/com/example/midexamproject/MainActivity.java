package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        loginBtn = findViewById(R.id.loginButton_main);
        loginBtn.setOnClickListener(e ->{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        signUpBtn = findViewById(R.id.registerButton_main);
        signUpBtn.setOnClickListener(e -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });

    }
}