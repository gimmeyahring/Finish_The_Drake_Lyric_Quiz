package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    int score;
    int currentIndex;
    Question currentQuestion;
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
        score = 0;
        currentIndex = 0;
        q0 = new Question("I want you to be mine again baby", "I know my lifestyle is driving you crazy");
        q1 = new Question("Asking me how did it feel", "Cant say it didnt surprise me");
        q2 = new Question("And we can hear the angels callin us", "And we can see the sunrise before us");
        q3 = new Question("Always been a lil mathematician", "Lately this cash Im gettin");
        q4 = new Question("Put the money in the bag", "Oops I just got a bag");
        q5 = new Question("OT OT theres never much love when we go OT", "I pray we make it back in one piece");
        q6 = new Question("I got chrome on my body", "Im the man of steel");
        q7 = new Question("And Im back on my grind", "A psychic read my life line");
        q8 = new Question("How many faking they streams", "Getting they plays from machines");
        q9 = new Question("Darling hold my hand", "Nothing beats a jet 2 holiday");
        questions = new Question[]{q0, q1, q2, q3, q4, q5, q6, q7, q8, q9};
        currentQuestion = questions[currentIndex];


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