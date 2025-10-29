package org.baltimorecityschools.finishthedrakelyricquiz;

import androidx.annotation.NonNull;

public class Question {
    // instance variables

    public String questionText;
    public String correctAnswer;
    public int songNumber;


    // constructors

    public Question(){
        questionText = "";
        correctAnswer = "";
        songNumber = 0;



    }

    public Question(String qtf, String caf, int snf){
        questionText = qtf;
        correctAnswer = caf;
        songNumber = snf;



    }

    // getters & setters

    public String getQuestionText(){return questionText;}
    public String getCorrectAnswer(){return correctAnswer;}
    public int getSongNumber(){return songNumber;}


    public void setQuestionText(String newQuestionText){questionText = newQuestionText;}
    public void setCorrectAnswer(String newCorrectAnswer){correctAnswer = newCorrectAnswer;}
    public void setSongNumber(int newSongNumber){songNumber = newSongNumber;}

    // methods


    @NonNull
    @Override
    public String toString() {
        return "This question is '" + questionText + "'. The answer is '" + correctAnswer +
                ". This song's number is " + songNumber + ".";
    }
}
