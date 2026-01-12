package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {


    // declare questions
    Question q0;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    Question q6;
    Question q7;
    Question q8;
    Question q9;

    Question[] questions;





    TextView answerMessage;
    TextView questionTV;
    EditText enterText;
    Button doneBTN;
    Button nextBTN;
    ImageButton hintBTN;
    MediaPlayer mediaPlayer1;
    RadioGroup radioGroupOptions;
    RadioButton radioOption0;
    RadioButton radioOption1;
    RadioButton radioOption2;
    RadioButton radioOption3;
    int userAnswer;
    int currentAnswer;

    int score;
    int currentIndex;
    Question currentQuestion;
    int currentSongIndex;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTV = (TextView) findViewById(R.id.questionTV);

        doneBTN = (Button) findViewById(R.id.doneBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        hintBTN = (ImageButton) findViewById(R.id.hintButton);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        radioOption0 = findViewById(R.id.radioOption1);
        radioOption1 = findViewById(R.id.radioOption2);
        radioOption2 = findViewById(R.id.radioOption3);
        radioOption3 = findViewById(R.id.radioOption4);
        int[] hintAudio = {R.raw.fettywapagain, R.raw.drakewhatdidimiss, R.raw.lilwaynmrsofficer,
                R.raw.lildurkallmylife, R.raw.yunomilesputthemoneyinthebag, R.raw.drakeonedance,
                R.raw.pbmmanofsteel, R.raw.kanywestiwonder, R.raw.savagealot, R.raw.laufeyfromthestart };
        score = 0;
        currentIndex = 0;
        q0 = new Question("I want you to be mine again baby", 0, 0);
        q1 = new Question("Asking me how did it feel", 3, 1);
        q2 = new Question("And we can hear the angels calling us", 3, 2);
        q3 = new Question("Always been a lil mathematician", 1, 3);
        q4 = new Question("Put the money in the bag", 2, 4);
        q5 = new Question("OT OT theres never much love when we go OT", 0, 5);
        q6 = new Question("I got chrome on my body", 0, 6);
        q7 = new Question("And Im back on my grind", 3, 7);
        q8 = new Question("How many faking they streams", 1, 8);
        q9 = new Question("Dont you notice how I get quiet when theres no one else around"
                , 2, 9);
        questions = new Question[]{q0, q1, q2, q3, q4, q5, q6, q7, q8, q9};
        currentQuestion = questions[currentIndex];

        radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioOption1) {
                    userAnswer = 0;
                }
                else if (checkedId == R.id.radioOption2) {
                    userAnswer = 1;
                }
                else if (checkedId == R.id.radioOption3) {
                    userAnswer = 2;
                }
                else if (checkedId == R.id.radioOption4) {
                    userAnswer = 3;
                }

            }
        });







        hintBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSongIndex = currentQuestion.getSongNumber();
                mediaPlayer1 = MediaPlayer.create(QuizActivity.this, hintAudio[currentSongIndex]);
                mediaPlayer1.start();


            }
        });

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doneBTN.setVisibility(View.GONE);
                if (userAnswer == currentQuestion.getCorrectAnswer()) {
                    score++;
                    Toast.makeText(QuizActivity.this, "You got it right!", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(QuizActivity.this, "You got it wrong!", Toast.LENGTH_LONG).show();
                }
            }

        });


        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentIndex == 9) {

                    Intent leaveIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    leaveIntent.putExtra("score", score);
                    startActivity(leaveIntent);
                }
                else
                {





                    currentIndex++;
                    currentQuestion = questions[currentIndex];
                    questionTV.setText(currentQuestion.getQuestionText());


                }

            }
        });


    }
}