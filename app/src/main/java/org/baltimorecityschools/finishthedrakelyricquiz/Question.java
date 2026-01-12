package org.baltimorecityschools.finishthedrakelyricquiz;

import androidx.annotation.NonNull;

public class Question {
    // instance variables

    public String questionText;
    public int correctAnswer;
    public int songNumber;
    String option1;
    String option2;
    String option3;
    String option4;




    // constructors

    public Question(){
        questionText = "";
        correctAnswer = 0;
        songNumber = 0;
        option1 = "";
        option2 = "";
        option3 = "";
        option4 = "";




    }

    public Question(String qtf, int caf, int snf, String o1, String o2, String o3, String o4){
        questionText = qtf;
        correctAnswer = caf;
        songNumber = snf;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;




    }

    // getters & setters

    public String getQuestionText(){return questionText;}
    public int getCorrectAnswer(){return correctAnswer;}
    public int getSongNumber(){return songNumber;}
    public String getOption1(){return option1;}
    public String getOption2(){return option2;}
    public String getOption3(){return option3;}
    public String getOption4(){return option4;}

    public void setQuestionText(String newQuestionText){questionText = newQuestionText;}
    public void setCorrectAnswer(int newCorrectAnswer){correctAnswer = newCorrectAnswer;}
    public void setSongNumber(int newSongNumber){songNumber = newSongNumber;}
    public void setOption1(String newOption1){option1 = newOption1;}
    public void setOption2(String newOption2){option2 = newOption2;}
    public void setOption3(String newOption3){option3 = newOption3;}
    public void setOption4(String newOption4){option4 = newOption4;}

    // methods

    @NonNull
    @Override
    public String toString() {
        return "This question is '" + questionText + "'. The answer is '" + correctAnswer +
                ". This song's number is " + songNumber + ".";
    }
}
