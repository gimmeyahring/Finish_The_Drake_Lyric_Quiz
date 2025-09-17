package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    int score;
    TextView scoreNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);
        scoreNumber = (TextView) findViewById(R.id.scoreNumber);
        scoreNumber.setText(String.valueOf(score));



    }
}