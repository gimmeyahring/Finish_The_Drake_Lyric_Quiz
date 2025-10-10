package org.baltimorecityschools.finishthedrakelyricquiz;

import androidx.annotation.NonNull;

public class Question {
    // instance variables

    public String questionText;
    public String correctAnswer;
    public String songName;

    // constructors

    public Question(){
        questionText = "";
        correctAnswer = "";
        songName = "";

    }

    public Question(String qtf, String caf, String snf){
        questionText = qtf;
        correctAnswer = caf;
        songName = snf;
    }

    // getters & setters

    public String getQuestionText(){return questionText;}
    public String getCorrectAnswer(){return correctAnswer;}
    public String getSongName(){return songName;}

    public void setQuestionText(String newQuestionText){questionText = newQuestionText;}
    public void setCorrectAnswer(String newCorrectAnswer){correctAnswer = newCorrectAnswer;}
    public void setSongName(String newSongName){songName = newSongName;}

    // methods


    @NonNull
    @Override
    public String toString() {
        return "This question is '" + questionText + "'. The answer is '" + correctAnswer + ". This song is called " + songName + ".";
    }
}
