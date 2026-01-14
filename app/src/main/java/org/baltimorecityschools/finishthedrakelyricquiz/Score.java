package org.baltimorecityschools.finishthedrakelyricquiz;

public class Score {
    public String username;
    public int score;


    public Score(){
        username = "";
        score = 0;
    }

    public Score(String un, int sc){
        username = un;
        score = sc;
    }

    public String getUsername(){return username;}
    public int getScore(){return score;}

    public void setUsername(String newUsername){username = newUsername;}
    public void setScore(int newScore){score = newScore;}

    @Override
    public String toString() {
        return "Score{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
