package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class TransactionHistory extends AppCompatActivity {

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        backBtn = findViewById(R.id.backButton_trans);
        backBtn.setOnClickListener(e -> {
            finish();
        });
    }
}