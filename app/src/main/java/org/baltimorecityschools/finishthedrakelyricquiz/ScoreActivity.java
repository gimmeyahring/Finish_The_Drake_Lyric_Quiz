package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView scoreNumber;
    Button emailBTN, leaderboardBTN, restartBTN;
    public static final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
    final String USERNAME_KEY = "USERNAME";








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);
        scoreNumber = (TextView) findViewById(R.id.scoreNumber);
        scoreNumber.setText(String.valueOf(score));
        emailBTN = (Button) findViewById(R.id.emailButton);
        leaderboardBTN = (Button) findViewById(R.id.leaderboardButton);
        restartBTN = (Button) findViewById(R.id.restartButton);
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);

        writeScore(sharedPreferences.getString(USERNAME_KEY, "User"), score);



        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail(sharedPreferences.getString(USERNAME_KEY, "User") + " scored a " + score + " in the 'Finish The Lyric' app",
                        "Finish The Lyric App Score");
            }
        });

        restartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }

    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(intent);
    }
    private void writeScore(String usernamea, int scorea) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("scores");
        Score score = new Score(usernamea, scorea);
        myRef.push().setValue(score)
                .addOnSuccessListener(aVoid ->{
                    System.out.println("Success");
                } )
                .addOnFailureListener(e -> {
                    System.out.println("Failure");
                });
    }


}