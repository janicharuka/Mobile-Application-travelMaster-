package com.example.testing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private EditText userNameEditText, userUsernameEditText, serviceEditText, commentsEditText;
    private RatingBar ratingBar;
    private Button submitReviewButton;
    private TextView reviewSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        // Initialize views
        userNameEditText = findViewById(R.id.userNameEditText);
        userUsernameEditText = findViewById(R.id.userUsernameEditText);
        serviceEditText = findViewById(R.id.serviceEditText);
        commentsEditText = findViewById(R.id.commentsEditText);
        ratingBar = findViewById(R.id.ratingBar);
        submitReviewButton = findViewById(R.id.submitReviewButton);
        reviewSummaryTextView = findViewById(R.id.reviewSummaryTextView);

        // Button click listener to submit the review
        submitReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from the input fields
                String name = userNameEditText.getText().toString().trim();
                String username = userUsernameEditText.getText().toString().trim();
                String service = serviceEditText.getText().toString().trim();
                String comments = commentsEditText.getText().toString().trim();
                float rating = ratingBar.getRating();

                // Validate input
                if (name.isEmpty() || username.isEmpty() || service.isEmpty() || comments.isEmpty()) {
                    Toast.makeText(ReviewActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (rating == 0) {
                    Toast.makeText(ReviewActivity.this, "Please provide a rating", Toast.LENGTH_SHORT).show();
                } else {
                    // Show review summary
                    String reviewSummary = "Name: " + name + "\n" +
                            "Username: " + username + "\n" +
                            "Service: " + service + "\n" +
                            "Rating: " + rating + " stars\n" +
                            "Comments: " + comments;

                    // Display the review summary
                    reviewSummaryTextView.setText(reviewSummary);
                    reviewSummaryTextView.setVisibility(View.VISIBLE);
                    Toast.makeText(ReviewActivity.this, "Review submitted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
