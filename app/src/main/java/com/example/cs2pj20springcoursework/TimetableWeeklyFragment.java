package com.example.cs2pj20springcoursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class TimetableWeeklyFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_timetable_weekly, container, false);

        Button weeklyButton = view.findViewById(R.id.weeklyButton);

        weeklyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainAppActivity) getActivity()).loadMonthlyFragment();
            }
        });

        return view;

    }

}
