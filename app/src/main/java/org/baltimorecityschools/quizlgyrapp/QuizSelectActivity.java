package org.baltimorecityschools.quizlgyrapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class QuizSelectActivity extends AppCompatActivity {

    final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
    final String USERNAME_KEY = "USERNAME";
    SharedPreferences openPreference;
    public String username;
    TextView usernameTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);
        usernameTV = findViewById(R.id.usernametext);
        openPreference = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        username = openPreference.getString(USERNAME_KEY, "User");
        usernameTV.setText(username);



    }
}