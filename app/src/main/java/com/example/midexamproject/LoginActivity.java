package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText email, pass;
    Button loginBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        email = findViewById(R.id.edtEmail_login);
        pass = findViewById(R.id.edtPassword_login);

        dbHelper = new DBHelper(this);

        loginBtn = findViewById(R.id.loginButton_login);
        loginBtn.setOnClickListener(e ->{
            if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill all the blank fields", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Boolean matchEmailPass = dbHelper.checkEmailPass(email.getText().toString(), pass.getText().toString());
                if (matchEmailPass){
                    Toast.makeText(LoginActivity.this,
                            "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, HomeActvity.class));
                    return;
                } else if (!matchEmailPass){
                    Toast.makeText(this,
                            "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        backBtn = findViewById(R.id.backButton_login);
        backBtn.setOnClickListener(e -> {
            finish();
        });

    }
}