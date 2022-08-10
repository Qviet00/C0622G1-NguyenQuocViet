package ss_8_Clean_Code_Refactoring.ss_2_exercise.Controller;

import ss_8_Clean_Code_Refactoring.ss_2_exercise.Model.TennisGame;

public class TennisGameTest {
    public static void main(String[] args) {
        String score = TennisGame.getScore(2,1);
        System.out.println(score);

    }
}
