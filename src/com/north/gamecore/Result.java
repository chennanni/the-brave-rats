package com.north.gamecore;

public class Result {

    public static String PLAYER_WIN_GAME = "playerWinGame";
    public static String PLAYER_ADD_ONE_SCORE = "playerAddOneScore";
    public static String PLAYER_ADD_TWO_SCORE = "playerAddTwoScore";
    public static String TIE = "tie";
    public static String HOLD = "hold";

    String result;
    Player winner;

    public void executeResult(Player p1, Player p2) {
        // add scores
        if (result == null) {
            unknownError();
        } else if (result.equalsIgnoreCase(PLAYER_WIN_GAME)) {
            playerWinGame(winner);
        } else if (result.equalsIgnoreCase(PLAYER_ADD_ONE_SCORE)) {
            playerAddOneScore(winner);
        } else if (result.equalsIgnoreCase(PLAYER_ADD_TWO_SCORE)) {
            playerAddTwoScore(winner);
        } else if (result.equalsIgnoreCase(TIE)) {
            tieRound();
        } else if (result.equalsIgnoreCase(HOLD)) {
            holdRound();
        } else {
            unknownError();
        }

        // count scores
        if (p1.getScore() >= 4) {
            p1.setWinFlag(true);
        } else if (p2.getScore() >= 4) {
            p2.setWinFlag(true);
        }
    }

    public static boolean isValidResult(Result r) {
        if (r == null || r.result == null) return false;
        return true;
    }

    private void playerAddOneScore(Player p) {
        p.setScore(p.getScore()+1);
        System.out.println(p.getName()+" win this round! Add 1 point."+"\n");
    }

    private void playerAddTwoScore(Player p) {
        p.setScore(p.getScore()+2);
        System.out.println(p.getName()+" win this round! Add 2 point."+"\n");
    }

    private void tieRound() {
        System.out.println("Tie..."+"\n");
    }

    private void holdRound() {
        System.out.println("Hold..."+"\n");
    }

    private void playerWinGame(Player p) {
        p.setWinFlag(true);
    }

    private void unknownError() {
        System.out.println("Error, please restart the game or contact admin."+"\n");
        System.exit(-1);
    }

}
