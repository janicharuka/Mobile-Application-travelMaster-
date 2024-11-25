package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find buttons
        Button toDoListButton = findViewById(R.id.toDoListButton);
        Button restaurantsButton = findViewById(R.id.restaurantsButton);
        Button transportationButton = findViewById(R.id.transportationButton);
        Button reviewsButton = findViewById(R.id.reviewsButton);

        // Set button click listeners
        toDoListButton.setOnClickListener(view -> {
            // Navigate to To-Do List
            Intent intent = new Intent(DashboardActivity.this, ToDoListActivity.class);
            startActivity(intent);
        });

        restaurantsButton.setOnClickListener(view -> {
            // Navigate to Restaurants Page
            Intent intent = new Intent(DashboardActivity.this, RestaurantsActivity.class);
            startActivity(intent);
        });
        transportationButton.setOnClickListener(view -> {

            Intent intent = new Intent(DashboardActivity.this, TransportationActivity.class);
            startActivity(intent);
        });
        reviewsButton.setOnClickListener(view -> {
            // Navigate to To-Do List
            Intent intent = new Intent(DashboardActivity.this, ReviewsActivity.class);
            startActivity(intent);
        });



    }
}
