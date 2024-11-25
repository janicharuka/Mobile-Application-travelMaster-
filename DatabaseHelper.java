package com.example.testing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper {

    private SQLiteDatabase database;
    private RegisterDatabaseHelper dbHelper;

    public DatabaseHelper(Context context) {
        dbHelper = new RegisterDatabaseHelper(context);
    }

    public void open() throws SQLException {
        // Open the database for writing or reading
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        // Close the database when done
        dbHelper.close();
    }

    // Method to insert registration data (used during registration)
    public long insertUser(String username, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(RegisterDatabaseHelper.COLUMN_USERNAME, username);
        values.put(RegisterDatabaseHelper.COLUMN_EMAIL, email);
        values.put(RegisterDatabaseHelper.COLUMN_PASSWORD, password);

        return database.insert(RegisterDatabaseHelper.TABLE_NAME, null, values);
    }

    // Method to validate login (checks if the user exists with matching credentials)
    public boolean validateLogin(String username, String password) {
        boolean isValid = false;

        // Query the database for the provided username and password
        String query = "SELECT * FROM " + RegisterDatabaseHelper.TABLE_NAME +
                " WHERE " + RegisterDatabaseHelper.COLUMN_USERNAME + " = ? AND " +
                RegisterDatabaseHelper.COLUMN_PASSWORD + " = ?";
        Cursor cursor = database.rawQuery(query, new String[]{username, password});

        if (cursor != null && cursor.getCount() > 0) {
            isValid = true;  // If user is found with matching credentials, valid login
        }

        // Close the cursor
        if (cursor != null) {
            cursor.close();
        }

        return isValid;
    }
}
