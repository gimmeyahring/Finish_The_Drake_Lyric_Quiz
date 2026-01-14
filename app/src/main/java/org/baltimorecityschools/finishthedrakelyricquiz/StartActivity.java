package org.baltimorecityschools.finishthedrakelyricquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class StartActivity extends AppCompatActivity {


    SharedPreferences openPreference;
    public static final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
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
        setContentView(R.layout.activity_start);

        enterUsername = (EditText) findViewById(R.id.setUsername);
        doneBTN = (Button) findViewById(R.id.donebut);
        usernameTV = findViewById(R.id.usernametextview);

        openPreference = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        editor = openPreference.edit();


        if (openPreference.getBoolean(FIRST_OPEN_KEY, true)){
            enterUsername.setVisibility(View.VISIBLE);



        }
        else {
            enterUsername.setVisibility(View.GONE);
            username = openPreference.getString(USERNAME_KEY, "User");
            usernameTV.setText(getString(R.string.welcome_backbut) + username);
            doneBTN.setText("@string/start_button");
            usernameTV.setVisibility(View.VISIBLE);
            doneBTN.setText("START");

        }

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (openPreference.getBoolean(FIRST_OPEN_KEY, true)) {
                    username = enterUsername.getText().toString();
                    if (username.length() > 13) {

                        Toast.makeText(StartActivity.this, "Username cant exceed 13 characters", Toast.LENGTH_LONG).show();
                        username = "";
                        enterUsername.setText(username);
                    } else {

                        editor.putBoolean(FIRST_OPEN_KEY, false);
                        editor.apply();
                        editor.putString(USERNAME_KEY, username);
                        editor.apply();
                        Intent leaveIntent;
                        leaveIntent = new Intent(StartActivity.this, QuizActivity.class);

                        startActivity(leaveIntent);
                    }
                }
                else {

                    Intent leaveIntent;
                    leaveIntent = new Intent(StartActivity.this, QuizActivity.class);

                    startActivity(leaveIntent);
                }

            }
        });









    }
}