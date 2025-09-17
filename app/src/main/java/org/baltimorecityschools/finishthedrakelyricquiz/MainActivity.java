package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    TextView answerMessage;
    EditText enterText;
    Button doneBTN;
    Button nextBTN;
    boolean answerBool = false;
    int score = 0;
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerMessage = (TextView) findViewById(R.id.answerMessage);
        enterText = (EditText) findViewById(R.id.enterTEXT);
        doneBTN = (Button) findViewById(R.id.doneBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = enterText.getText().toString();
                if (answer.equals("I know my lifestyle is driving you crazy")){
                    answerBool = true;
                    score++;
                }
                else {
                    answerBool = false;
                }

                if (answerBool == true){
                    answerMessage.setText("GOOD JOB! You Got It Right!");
                    Toast.makeText(MainActivity.this, "You got it right!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    answerMessage.setText("OH NO... You Got It Wrong!");
                }
            }
        });


        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaveIntent = new Intent(MainActivity.this, MainActivity2.class);
                leaveIntent.putExtra("score", score);
                startActivity(leaveIntent);
            }
        });


    }
}