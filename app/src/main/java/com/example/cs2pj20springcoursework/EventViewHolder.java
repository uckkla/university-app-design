package com.example.cs2pj20springcoursework;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class EventViewHolder extends RecyclerView.ViewHolder {
    public TextView moduleTextView;
    public TextView roomTextView;
    public TextView startTimeTextView;
    public TextView endTimeTextView;

    public EventViewHolder(View itemView){
        super(itemView);
        moduleTextView = itemView.findViewById(R.id.moduleTextView);
        roomTextView = itemView.findViewById(R.id.roomTextView);
        startTimeTextView = itemView.findViewById(R.id.startTimeTextView);
        endTimeTextView = itemView.findViewById(R.id.endTimeTextView);
    }
}
