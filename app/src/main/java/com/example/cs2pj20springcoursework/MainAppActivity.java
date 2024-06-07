package com.example.cs2pj20springcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        MenuFragment menuFragment = new MenuFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_menu, menuFragment)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new ProfileFragment())
                .commit();
    }

    // Both methods used to alternate between fragments - monthly & weekly
    // Called by its individual fragment
    public void loadMonthlyFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new TimetableMonthlyFragment())
                .commit();
    }

    public void loadWeeklyFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new TimetableWeeklyFragment())
                .commit();
    }

    public void loadEditProfileFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new EditProfileFragment())
                .commit();
    }

    public void loadProfileFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new ProfileFragment())
                .commit();
    }
}