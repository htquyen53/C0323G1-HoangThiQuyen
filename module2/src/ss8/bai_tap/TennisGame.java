package ss8.bai_tap;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static String displayScore = "";

    public static String getScore(int firstPlayerScore, int secondPlayerScore) {
        if (firstPlayerScore == secondPlayerScore) {
            switch (firstPlayerScore) {
                case LOVE:
                    displayScore = "Love-All";
                    break;
                case FIFTEEN:
                    displayScore = "Fifteen-All";
                    break;
                case THIRTY:
                    displayScore = "Thirty-All";
                    break;
                case FORTY:
                    displayScore = "Forty-All";
                    break;
                default:
                    displayScore = "Deuce";
                    break;
            }
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            int minusResult = firstPlayerScore - secondPlayerScore;
            checkResult(minusResult);
        } else {
            checkTempScore(firstPlayerScore, secondPlayerScore);
        }
        return displayScore;
    }

    public static String checkResult(int result) {
        if (result == 1) displayScore = "Advantage player1";
        else if (result == -1) displayScore = "Advantage player2";
        else if (result >= 2) displayScore = "Win for player1";
        else displayScore = "Win for player2";
        return displayScore;
    }

    public static String checkTempScore(int firstPlayerScore, int secondPlayerScore) {
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                displayScore += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case LOVE:
                    displayScore += "Love";
                    break;
                case FIFTEEN:
                    displayScore += "Fifteen";
                    break;
                case THIRTY:
                    displayScore += "Thirty";
                    break;
                case FORTY:
                    displayScore += "Forty";
                    break;
            }
        }
        return displayScore;
    }
}

