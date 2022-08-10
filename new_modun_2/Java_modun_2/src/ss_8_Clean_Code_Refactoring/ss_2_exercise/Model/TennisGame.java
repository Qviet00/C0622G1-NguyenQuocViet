package ss_8_Clean_Code_Refactoring.ss_2_exercise.Model;

public class TennisGame {
    public static String getScore(int m_score1, int m_score2) {
        boolean isDraw = m_score1 == m_score2;
        boolean isDraw2 = m_score1 >= 4 || m_score2 >= 4;
        if (isDraw) {
            return getStringBuilder(m_score1);
        } else {
            if (isDraw2) {
                return getStringBuilderOne(m_score1, m_score2);
            } else {
                return getStringBuilderTwo(m_score1, m_score2);
            }
        }
    }

    private static String getStringBuilder(int m_score1) {
        String score;
        switch (m_score1) {
            case 0 -> score = "Love-All";
            case 1 -> score = "Fifteen-All";
            case 2 -> score = "Thirty-All";
            case 3 -> score = "Forty-All";
            default -> score = "Deuce";
        }
        return score;
    }

    private static String getStringBuilderOne(int m_score1, int m_score2) {
        int core = m_score1 - m_score2;
        String  string;
        if (core == 1) {
             string = "Advantage player2";
        } else {
            if (core == -1) {
                 string = "Advantage player2";
            } else {
                if (core >= 2) {
                     string = "Win for player1";
                } else  string = "Win for player2";
            }
        }
        return  string;
    }

    private static String getStringBuilderTwo(int a, int b) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = a;
            else {
                score.append("-");
                tempScore = b;
            }
            switch (tempScore) {
                case 0 -> score.append("Love");
                case 1 -> score.append("Fifteen");
                case 2 -> score.append("Thirty");
                case 3 -> score.append("Forty");
            }
        }
        return score.toString();
    }
}