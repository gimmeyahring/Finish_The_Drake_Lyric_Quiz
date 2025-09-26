package org.baltimorecityschools.finishthedrakelyricquiz;

import androidx.annotation.NonNull;

public class Question {
    // instance variables

    public String questionText;
    public String correctAnswer;

    // constructors

    public Question(){
        questionText = "";
        correctAnswer = "";

    }

    public Question(String qtf, String caf){
        questionText = qtf;
        correctAnswer = caf;
    }

    // getters & setters

    public String getQuestionText(){return questionText;}
    public String getCorrectAnswer(){return correctAnswer;}

    public void setQuestionText(String newQuestionText){questionText = newQuestionText;}
    public void setCorrectAnswer(String newCorrectAnswer){correctAnswer = newCorrectAnswer;}

    // methods


    @NonNull
    @Override
    public String toString() {
        return "This question is '" + questionText + "'. The answer is '" + correctAnswer + "'.";
    }
}
