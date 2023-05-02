package com.example.midexamproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midexamproject.data.NewsData;

import java.util.Vector;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context ctx;

    static Vector<NewsData> news;
    static LinearLayout linearLayout;


    public NewsAdapter(Context ctx, Vector<NewsData> news) {
        this.ctx = ctx;
        this.news = news;
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        NewsData newsData = news.get(position);

        holder.newsTitle.setText(newsData.newsTitle);
        holder.newsDate.setText(newsData.newsDate);
        holder.newsImg.setImageResource(newsData.newsImg);

        linearLayout.setOnClickListener(e->{
            Intent intent = new Intent(e.getContext(), NewsDetail.class);
            intent.putExtra("NewsTitle", newsData.newsTitle);
            intent.putExtra("NewsDate", newsData.newsDate);
            intent.putExtra("NewsDesc", newsData.newsDescription);
            intent.putExtra("NewsImg", newsData.newsImg);

            ctx.startActivity(intent);

            intent.removeExtra("NewsTitle");
            intent.removeExtra("NewsDate");
            intent.removeExtra("NewsDesc");
            intent.removeExtra("NewsImg");
        });

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDate;
        ImageView newsImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.news_item);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDate = itemView.findViewById(R.id.news_date);
            newsImg = itemView.findViewById(R.id.news_Image);

        }
    }
}
