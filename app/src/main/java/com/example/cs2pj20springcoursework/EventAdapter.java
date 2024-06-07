package com.example.cs2pj20springcoursework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>{

    private List<EventCell> eventList;

    public EventAdapter(List<EventCell> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for the event item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_cell_layout, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventCell event = eventList.get(position);
        holder.moduleTextView.setText(event.getModuleName());
        holder.roomTextView.setText(event.getRoomName());
        holder.startTimeTextView.setText(event.getStartTime());
        holder.endTimeTextView.setText(event.getEndTime());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setData(List<EventCell> newData) {
        eventList = newData;
    }
}
