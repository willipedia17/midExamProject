package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActvity extends AppCompatActivity {

    Button history;

    BottomNavigationView navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_actvity);

        getSupportActionBar().hide();

        history = findViewById(R.id.transHistory_button);
        history.setOnClickListener(e ->{
            startActivity(new Intent(this, TransactionHistory.class));
        });

        navBar = findViewById(R.id.navBar);
        navBar.setOnItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            switch (item.getItemId()){
                case R.id.news_navbar:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, NewsFragment.class, null).commit();
                    return true;
                case R.id.schedule_navbar:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ScheduleFragment.class, null).commit();
                    return true;
                default:
                    return false;
            }
        });


    }
}