package org.baltimorecityschools.quizlgyrapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    SharedPreferences openPreference;
    final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
    final String FIRST_OPEN_KEY = "FIRSTOPEN";
    final String USERNAME_KEY = "USERNAME";

    Button doneBTN;
    EditText enterUsername;
    TextView usernameTV;
    String username;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterUsername = (EditText) findViewById(R.id.setUsername);
        doneBTN = (Button) findViewById(R.id.donebut);
        usernameTV = findViewById(R.id.usernametextview);
        username = "User";
        openPreference = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        editor = openPreference.edit();


        if (openPreference.getBoolean(FIRST_OPEN_KEY, true)){
            enterUsername.setVisibility(View.VISIBLE);
            editor.putBoolean(FIRST_OPEN_KEY, false);
            editor.apply();


        }
        else {
            enterUsername.setVisibility(View.GONE);
            username = openPreference.getString(USERNAME_KEY, "User");
            usernameTV.setText("Welcome back " + username);
            usernameTV.setVisibility(View.VISIBLE);
            doneBTN.setText("START");

        }

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = enterUsername.getText().toString();
                if (username.length() > 13) {
                    Toast.makeText(MainActivity.this, "Username cant exceed 13 characters", Toast.LENGTH_LONG).show();
                    username = "";
                    enterUsername.setText(username);
                } else {
                    username = enterUsername.getText().toString();
                    editor.putString(USERNAME_KEY, username);
                    editor.apply();
                    Intent leaveIntent;
                    leaveIntent = new Intent(MainActivity.this, QuizSelectActivity.class);
                    startActivity(leaveIntent);
                }

            }
        });


    }
}