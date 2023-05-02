package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midexamproject.data.NewsData;
import com.example.midexamproject.data.ScheduleData;

import java.util.Vector;

public class ScheduleDetail extends AppCompatActivity {

    Vector<ScheduleData> scheduleDataVector;
    ScheduleAdapter scheduleAdapter;

    TextView team1_view,  team2_view, date_view, time_view, place_view;
    ImageView image1_view, image2_view;

    String team1, team2, date, time, place;
    Integer team1_img, team2_img;

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        backBtn = findViewById(R.id.backButton_scheduleDet);
        backBtn.setOnClickListener(v -> finish());

        scheduleAdapter = new ScheduleAdapter(this, scheduleDataVector);

        team1 = getIntent().getStringExtra("team1");
        team2 = getIntent().getStringExtra("team2");
        team1_img = getIntent().getIntExtra("team1_img", 0);
        team2_img = getIntent().getIntExtra("team2_img", 0);
        date = getIntent().getStringExtra("date");
        time = getIntent().getStringExtra("time");
        place = getIntent().getStringExtra("place");

    }
}