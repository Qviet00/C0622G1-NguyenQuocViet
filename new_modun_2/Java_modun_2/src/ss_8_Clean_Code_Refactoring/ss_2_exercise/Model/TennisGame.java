package ss_8_Clean_Code_Refactoring.ss_2_exercise.Model;

public class TennisGame {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;

    public static String getScore(int m_score1, int m_score2) {

        boolean isDraw = m_score1 == m_score2;
        boolean isDraw2 = m_score1 >= FOUR || m_score2 >= FOUR;
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
            case ZERO -> score = "Love-All";
            case ONE -> score = "Fifteen-All";
            case TWO -> score = "Thirty-All";
            case THREE -> score = "Forty-All";
            default -> score = "Deuce";
        }
        return score;
    }

    private static String getStringBuilderOne(int m_score1, int m_score2) {
        int core = m_score1 - m_score2;
        String string;
        if (core == ONE) {
            string = "Advantage player2";
        } else {
            if (core == -ONE) {
                string = "Advantage player2";
            } else {
                if (core >= TWO) {
                    string = "Win for player1";
                } else string = "Win for player2";
            }
        }
        return string;
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
                case ZERO -> score.append("Love");
                case ONE -> score.append("Fifteen");
                case TWO -> score.append("Thirty");
                case THREE -> score.append("Forty");
            }
        }
        return score.toString();
    }

}