package com.example.cs2pj20springcoursework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsFragment extends Fragment {

    private List<NewsCell> newsList;
    private NewsAdapter newsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.newsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Popular news cells
        newsList = new ArrayList<>();
        newsList.add(new NewsCell(R.drawable.stock_photo1, "New Learning Area Open", "30-03-2024 at 10:00", "New section in the library open for students to learn in! As it is a study room, you must remain quiet and avoid eating/drinking."));
        newsList.add(new NewsCell(R.drawable.stock_photo2, "Server Maintenance", "10-04-2024 at 9:00", "Servers will need to go down for maintenance for 4 days, meaning risis support will be unavailable."));
        newsList.add(new NewsCell(R.drawable.stock_photo3, "Online Session Available", "05-04-2024 at 12:00", "Online session for programming with java available for all 2nd year computer science students."));
        newsList.add(new NewsCell(R.drawable.stock_photo4, "Extra Learning Available", "30-03-2024 at 11:00", "Extra support is available during the Easter period on Microsoft Teams, contact here: www.foobar.co.uk"));

        // Parse the dates and sort the list
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm", Locale.getDefault());
        Collections.sort(newsList, new Comparator<NewsCell>() {
            @Override
            public int compare(NewsCell news1, NewsCell news2) {
                try {
                    Date date1 = dateFormat.parse(news1.getDate());
                    Date date2 = dateFormat.parse(news2.getDate());
                    return date2.compareTo(date1); // Descending order
                } catch (Exception e) {
                    Log.e("NewsFragment", "Error parsing date", e);
                    return 0;
                }
            }
        });

        Log.d("Size of array: ", String.valueOf(newsList.size()));
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

        return view;
    }
}