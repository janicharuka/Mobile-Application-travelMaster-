package com.example.testing;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;
    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        recyclerView = findViewById(R.id.restaurantsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Pizza Palace", "Delicious pizzas with fresh ingredients", R.drawable.travel3));
        restaurantList.add(new Restaurant("Burger Haven", "Juicy burgers and crispy fries", R.drawable.travel5));
        restaurantList.add(new Restaurant("Pasta Paradise", "Authentic Italian pasta dishes", R.drawable.travel3));
        restaurantList.add(new Restaurant("Pizza Palace", "Delicious pizzas with fresh ingredients", R.drawable.travel3));
        restaurantList.add(new Restaurant("Pizza Palace", "Delicious pizzas with fresh ingredients", R.drawable.travel3));

        adapter = new RestaurantAdapter(this, restaurantList);
        recyclerView.setAdapter(adapter);
    }
}
