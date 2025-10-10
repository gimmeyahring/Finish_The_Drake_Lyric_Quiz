package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;



public class StartActivity extends AppCompatActivity {


    Button startBTN;
    public int number = 0;
    MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startBTN = findViewById(R.id.startButton);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.fettywapagain);
        mediaPlayer1.start();

        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaveIntent = new Intent(StartActivity.this, QuizActivity.class);
                startActivity(leaveIntent);
            }
        });








    }
}