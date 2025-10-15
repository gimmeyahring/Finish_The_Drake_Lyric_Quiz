package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

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

    int score;
    int currentIndex;
    Question currentQuestion;
    int currentSongIndex;
    String currentAnswer = "";
    String userAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTV = (TextView) findViewById(R.id.questionTV);
        answerMessage = (TextView) findViewById(R.id.answerMessage);
        enterText = (EditText) findViewById(R.id.enterTEXT);
        doneBTN = (Button) findViewById(R.id.doneBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        hintBTN = (ImageButton) findViewById(R.id.hintButton);
        int[] hintAudio = {R.raw.fettywapagain, R.raw.drakewhatdidimiss, R.raw.lilwaynmrsofficer,
                R.raw.lildurkallmylife, R.raw.yunomilesputthemoneyinthebag, R.raw.drakeonedance,
                R.raw.pbmmanofsteel, R.raw.kanywestiwonder, R.raw.savagealot, R.raw.laufeyfromthestart };
        score = 0;
        currentIndex = 0;
        q0 = new Question("I want you to be mine again baby", "I know my lifestyle is " +
                "driving you crazy", 0);
        q1 = new Question("Asking me how did it feel", "Cant say it didnt surprise me", 1);
        q2 = new Question("And we can hear the angels calling us", "And we can see the " +
                "sunrise before us", 2);
        q3 = new Question("Always been a lil mathematician", "Lately this cash Im getting", 3);
        q4 = new Question("Put the money in the bag", "Oops I just got a bag", 4);
        q5 = new Question("OT OT theres never much love when we go OT", "I pray we make it " +
                "back in one piece", 5);
        q6 = new Question("I got chrome on my body", "Im the man of steel", 6);
        q7 = new Question("And Im back on my grind", "A psychic read my life line", 7);
        q8 = new Question("How many faking they streams", "Getting they plays from machines", 8);
        q9 = new Question("Dont you notice how I get quiet when theres no one else around"
                , "Me and you and akward silence", 9);
        questions = new Question[]{q0, q1, q2, q3, q4, q5, q6, q7, q8, q9};
        currentQuestion = questions[currentIndex];







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


                userAnswer = enterText.getText().toString();
                currentAnswer = currentQuestion.getCorrectAnswer();





                if (userAnswer.equals(currentAnswer)){

                    score++;
                    answerMessage.setText("GOOD JOB! You Got It Right!");
                    Toast.makeText(QuizActivity.this, "You got it right!", Toast.LENGTH_LONG).show();
                }
                else {

                    answerMessage.setText("OH NO... You Got It Wrong!");
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



                    enterText.setText("");
                    answerMessage.setText("");
                    currentIndex++;
                    currentQuestion = questions[currentIndex];
                    questionTV.setText(currentQuestion.getQuestionText());


                }

            }
        });


    }
}