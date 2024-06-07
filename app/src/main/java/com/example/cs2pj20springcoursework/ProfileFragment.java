package com.example.cs2pj20springcoursework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class ProfileFragment extends Fragment {

    private TextView editTextName;
    private TextView editTextStudentNumber;
    private TextView editTextCourse;
    private TextView editTextAcademicYear;
    private TextView editTextLearningTrack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        editTextName = view.findViewById(R.id.studentNameTextView);
        editTextStudentNumber = view.findViewById(R.id.studentNumberTextView);
        editTextCourse = view.findViewById(R.id.courseTextView);
        editTextAcademicYear = view.findViewById(R.id.academicYearTextView);
        editTextLearningTrack = view.findViewById(R.id.learningTrackTextView);

        Button editInfoButton = view.findViewById(R.id.infoButton);
        editInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainAppActivity) getActivity()).loadEditProfileFragment();
            }
        });

        return view;
    }

    public void updateProfile(String newName, String newStudentNumber, String newCourse, String newAcademicYear, String newLearningTrack) {
        editTextName.setText(newName);
        editTextStudentNumber.setText(newStudentNumber);
        editTextCourse.setText(newCourse);
        editTextAcademicYear.setText(newAcademicYear);
        editTextLearningTrack.setText(newLearningTrack);
    }
}