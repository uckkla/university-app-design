package com.example.cs2pj20springcoursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class EditProfileFragment extends Fragment {
    private EditText editTextName, editTextStudentNumber, editTextCourse, editTextAcademicYear, editTextLearningTrack;
    private Button applyChangesButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextStudentNumber = view.findViewById(R.id.editTextStudentNumber);
        editTextCourse = view.findViewById(R.id.editTextCourse);
        editTextAcademicYear = view.findViewById(R.id.editTextAcademicYear);
        editTextLearningTrack = view.findViewById(R.id.editTextLearningTrack);

        applyChangesButton = view.findViewById(R.id.applyChangesButton);

        applyChangesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateProfile();
            }
        });

        Button toProfileButton = view.findViewById(R.id.infoButton);
        toProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainAppActivity) getActivity()).loadProfileFragment();
            }
        });
        return view;

    }

    private void updateProfile() {
        String newName = editTextName.getText().toString().trim();
        String newStudentNumber = editTextStudentNumber.getText().toString().trim();
        String newCourse = editTextCourse.getText().toString().trim();
        String newAcademicYear = editTextAcademicYear.getText().toString().trim();
        String newLearningTrack = editTextLearningTrack.getText().toString().trim();
    }
}
