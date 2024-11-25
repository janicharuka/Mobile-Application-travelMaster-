package com.example.testing;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity {

    private EditText userNameEditText, numSeatsEditText, specialNotesEditText;
    private TextView bookingDateTextView, bookingTimeTextView;
    private Button reserveButton;

    private String restaurantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        restaurantName = getIntent().getStringExtra("restaurant_name");

        // Initialize views
        TextView restaurantNameTextView = findViewById(R.id.restaurant_name_label);
        restaurantNameTextView.setText(restaurantName);

        userNameEditText = findViewById(R.id.restaurant_name);
        numSeatsEditText = findViewById(R.id.num_seats);
        specialNotesEditText = findViewById(R.id.special_notes);
        bookingDateTextView = findViewById(R.id.booking_date);
        bookingTimeTextView = findViewById(R.id.booking_time);
        reserveButton = findViewById(R.id.reserve_button);

        // Date Picker
        bookingDateTextView.setOnClickListener(v -> showDatePickerDialog());

        // Time Picker
        bookingTimeTextView.setOnClickListener(v -> showTimePickerDialog());

        // Reserve Button
        reserveButton.setOnClickListener(v -> handleReservation());
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> bookingDateTextView.setText(year1 + "-" + (monthOfYear + 1) + "-" + dayOfMonth),
                year, month, day
        );
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute1) -> bookingTimeTextView.setText(hourOfDay + ":" + minute1),
                hour, minute, true
        );
        timePickerDialog.show();
    }

    private void handleReservation() {
        String userName = userNameEditText.getText().toString();
        String bookingDate = bookingDateTextView.getText().toString();
        String bookingTime = bookingTimeTextView.getText().toString();
        String numSeats = numSeatsEditText.getText().toString();
        String specialNotes = specialNotesEditText.getText().toString();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(bookingDate) || TextUtils.isEmpty(bookingTime) || TextUtils.isEmpty(numSeats)) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Reservation for " + restaurantName + " confirmed!", Toast.LENGTH_SHORT).show();
            // Save reservation data here
        }
    }
}
