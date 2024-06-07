package com.example.cs2pj20springcoursework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private List<NewsCell> newsList;

    public NewsAdapter(List<NewsCell> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for the event item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_cell_layout, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsCell news = newsList.get(position);
        holder.newsImage.setImageResource(news.getImageResource());
        holder.newsTitle.setText(news.getTitle());
        holder.newsDate.setText(news.getDate());
        holder.newsDescription.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setData(List<NewsCell> newData) {
        newsList = newData;
    }
}
