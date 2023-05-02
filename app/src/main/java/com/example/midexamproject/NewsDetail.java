    package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midexamproject.data.NewsData;

import java.util.Vector;

    public class NewsDetail extends AppCompatActivity {

    Vector<NewsData> newsDataVector;
    NewsAdapter newsAdapter;

    TextView title_view,  desc_view, date_view;
    ImageView image_view;

    String newsTitle, newsDate, newsDescription;
    int newsImg;

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        getSupportActionBar().hide();

        backBtn = findViewById(R.id.backButton_detail);
        backBtn.setOnClickListener(v -> {
            finish();
        });

        newsAdapter = new NewsAdapter(this, newsDataVector);

        newsTitle = getIntent().getStringExtra("NewsTitle");
        newsImg = getIntent().getIntExtra("NewsImg", 0);
        newsDate = getIntent().getStringExtra("NewsDate");
        newsDescription = getIntent().getStringExtra("NewsDesc");

        getIntent().removeExtra("NewsTitle");
        getIntent().removeExtra("NewsImg");
        getIntent().removeExtra("NewsDate");
        getIntent().removeExtra("NewsDesc");

        title_view = findViewById(R.id.news_Title_detail);
        image_view = findViewById(R.id.news_Image_detail);
        desc_view = findViewById(R.id.news_Desc_detail);
        date_view = findViewById(R.id.news_date_detail);

        title_view.setText(newsTitle);
        image_view.setImageResource(newsImg);
        desc_view.setText(newsDescription);
        date_view.setText(newsDate);

    }
}