package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView scoreNumber;
    Button emailBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);
        scoreNumber = (TextView) findViewById(R.id.scoreNumber);
        scoreNumber.setText(String.valueOf(score));
        emailBTN = (Button) findViewById(R.id.emailButton);

        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail("I scored a " + score + "in the 'Finish The Lyric' app", "Finish The Lyric App Score");
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


}