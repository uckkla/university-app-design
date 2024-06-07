package com.example.cs2pj20springcoursework;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder{

    public ImageView newsImage;
    public TextView newsTitle;
    public TextView newsDate;
    public TextView newsDescription;


    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage = itemView.findViewById(R.id.newsImage);
        newsTitle = itemView.findViewById(R.id.newsTitle);
        newsDate = itemView.findViewById(R.id.newsDate);
        newsDescription = itemView.findViewById(R.id.newsDescription);
    }
}
