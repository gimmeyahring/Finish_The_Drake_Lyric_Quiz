package org.baltimorecityschools.quizlgyrapp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class QuizSelectActivity extends AppCompatActivity {

    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);
        Intent intent = getIntent();
        username = intent.getStringExtra(username);

    }
}