package com.example.cs2pj20springcoursework;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimetableMonthlyFragment extends Fragment {

    private List<EventCell> eventList;
    private EventAdapter eventAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable_monthly, container, false);

        // Getting necessary views/buttons
        Button monthlyButton = view.findViewById(R.id.monthlyButton);
        CalendarView calendarView = view.findViewById(R.id.calendar);
        RecyclerView recyclerView = view.findViewById(R.id.calendarRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Sampling data
        eventList = new ArrayList<>();
        eventList.add(new EventCell("Module 1", "Room 101", "2024-03-26","08:00", "10:00"));
        eventList.add(new EventCell("Module 2", "Room 102", "2024-03-26","10:00", "12:00"));
        eventList.add(new EventCell("Module 3", "Room 104", "2024-03-25","09:00", "10:00"));
        eventList.add(new EventCell("Module 4", "Room 55", "2024-03-25","10:00", "13:00"));
        eventList.add(new EventCell("Module 5", "Room 121", "2024-03-24","15:00", "16:00"));
        eventList.add(new EventCell("Module 6", "Room 101", "2024-03-24","13:00", "14:00"));

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        setInitialDateEvents();

        monthlyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainAppActivity) getActivity()).loadWeeklyFragment();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // When a day is clicked, retrieve the selected date
                String selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);

                // 2. Filter Events by Date
                List<EventCell> filteredEvents = filterEventsByDate(selectedDate);

                // 3. Update RecyclerView Adapter
                updateRecyclerView(filteredEvents);
                Log.d("selectedDate: ", selectedDate);
            }
        });
        return view;
    }

    private List<EventCell> filterEventsByDate(String selectedDate){
        List<EventCell> filteredEvents = new ArrayList<>();
        for (EventCell event : eventList) {
            if (event.getDate().equals(selectedDate)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }

    private void updateRecyclerView(List<EventCell> filteredEvents) {
        eventAdapter.setData(filteredEvents);
        eventAdapter.notifyDataSetChanged();
    }

    private void setInitialDateEvents(){
        // Get current date, used for when timetable is first started
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Format the current date to match the format in Event objects
        String currentDateString = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
        List<EventCell> filteredEvents = filterEventsByDate(currentDateString);
        updateRecyclerView(filteredEvents);
    }
}
