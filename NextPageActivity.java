package com.example.testing; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NextPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        // Initialize the Back to Home button
        Button backToHomeButton = findViewById(R.id.backToHomeButton);

        // Set onClickListener for the button
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to HomeActivity
                Intent intent = new Intent(NextPageActivity.this, com.example.testing.HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
