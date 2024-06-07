package com.example.cs2pj20springcoursework;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    private LinearLayout dashboard, profile, timetable, news;
    private TextView dashboardText, profileText, timetableText, newsText;
    private ImageView dashboardImage, profileImage, timetableImage, newsImage;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_layout, container, false);
        // Initialise containers
        dashboard = view.findViewById(R.id.dashboardContainer);
        profile = view.findViewById(R.id.profileContainer);
        timetable = view.findViewById(R.id.timetableContainer);
        news = view.findViewById(R.id.newsContainer);

        // Initialise TextViews and images, used for changing colour
        dashboardText = dashboard.findViewById(R.id.dashboardText);
        profileText = profile.findViewById(R.id.profileText);
        timetableText = timetable.findViewById(R.id.timetableText);
        newsText = news.findViewById(R.id.newsText);
        dashboardImage = dashboard.findViewById(R.id.dashboardImage);
        profileImage = profile.findViewById(R.id.profileImage);
        timetableImage = timetable.findViewById(R.id.timetableImage);
        newsImage = news.findViewById(R.id.newsImage);

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update UI to indicate selected menu item
                updateUI(v);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update UI to indicate selected menu item
                updateUI(v);
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update UI to indicate selected menu item
                updateUI(v);
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update UI to indicate selected menu item
                updateUI(v);
            }
        });
        return view;
    }

    private void updateUI(View selectedView){
        Log.d("MenuFragment", "Selected view ID: " + selectedView.getId());
        resetMenu();
        TextView selectedText = null;
        ImageView selectedImage = null;
        Fragment selectedFragment = null;

        if (selectedView.getId() == dashboard.getId()) {
            selectedFragment = new DashboardFragment();
            selectedText = dashboardText;
            selectedImage = dashboardImage;
        } else if (selectedView.getId() == profile.getId()) {
            selectedFragment = new ProfileFragment();
            selectedText = profileText;
            selectedImage = profileImage;
        } else if (selectedView.getId() == timetable.getId()) {
            selectedFragment = new TimetableMonthlyFragment();
            selectedText = timetableText;
            selectedImage = timetableImage;
        } else if (selectedView.getId() == news.getId()) {
            selectedFragment = new NewsFragment();
            selectedText = newsText;
            selectedImage = newsImage;
        }

        // Set the text color and image of the selected TextView
        if (selectedText != null && selectedImage != null) {
            selectedText.setTextColor(Color.parseColor("#204FEB"));
            selectedImage.setColorFilter(ContextCompat.getColor(requireContext(), R.color.dark_blue), PorterDuff.Mode.SRC_IN);
        }

        if (selectedFragment != null) {
            // Replace the fragment container with the selected fragment
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment)
                    .commit();
        }
    }

    private void resetMenu(){
        // reset colours for whole menu
        dashboardText.setTextColor(Color.BLACK);
        profileText.setTextColor(Color.BLACK);
        timetableText.setTextColor(Color.BLACK);
        newsText.setTextColor(Color.BLACK);

        dashboardImage.setColorFilter(null);
        profileImage.setColorFilter(null);
        timetableImage.setColorFilter(null);
        newsImage.setColorFilter(null);

    }
}
