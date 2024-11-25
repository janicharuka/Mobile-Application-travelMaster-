package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure you have the correct layout file name here
        setContentView(R.layout.activity_dashboard);

        // Set up click listeners for cards



    }

    private void openToDoList() {
        // Start To-Do List Activity
        Intent intent = new Intent(MainActivity.this, ToDoActivity.class);
        startActivity(intent);
    }

    private void openRestaurants() {
        // Start Restaurants Activity
        Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
        startActivity(intent);
    }


}
