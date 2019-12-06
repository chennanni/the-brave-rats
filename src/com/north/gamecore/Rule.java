package com.north.gamecore;

public class Rule {
    public static Result battle(Player p1, Card c1, Player p2, Card c2) {
        if (p1 == null || p2 == null || c1 == null || c2 == null) return null;
        Result r = new Result();

        // when cards are the same, magic is nullified and it's a tie game
        if (c1.getNumber() == c2.getNumber()) {
            r.result = Result.TIE;
            checkPoints(p1, c1, p2, c2, r);
        }

        // 7-6
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            // 6 – General: The next card you play gets +2 strength.
            p2.setStrength(2);
        }

        // 7-5
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            // 5 – Wizard: Nullify your opponent’s special ability.
            // do nothing because Prince’s ability trumps the Wizard's ability
        }

        // 7-4
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            // 4 – Ambassador: If you win, it counts as 2 rounds.
            // do nothing
        }

        // 7-3
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            // 3 – Assassin: The lower strength wins instead.
            // do nothing because Prince’s ability trumps the Assassin's ability
        }

        // 7-2
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            //2 – Spy: Next round, you choose a card after your opponent reveals theirs.
            p2.setPlayLateHand(true);
        }

        // 7-1
        if (c1.getNumber() == 7 && c2.getNumber() == 1) {
            // 7 – Prince: You win the round.
            // 1 – Princess: If your opponent plays the Prince you win the whole game.
            winThisGame(p2, r);
            clearBuff(p1, p2);
        }

        // 7-0
        if (c1.getNumber() == 7 && c2.getNumber() == 0) {
            // 7 – Prince: You win the round.
            winThisRound(p1, r);
            clearBuff(p1, p2);
            // 0 – Musician: This round is on hold.
            // do nothing because Prince’s ability trumps the Musician's ability
        }

        // 6-5
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 6 – General: The next card you play gets +2 strength.
            // 5 – Wizard: Nullify your opponent’s special ability.
            checkPoints(p1, c1, p2, c2, r);
        }

        // 6-4
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 4 – Ambassador: If you win, it counts as 2 rounds.
            p2.setHoldOneRound(true);
            checkPoints(p1, c1, p2, c2, r);
            // 6 – General: The next card you play gets +2 strength.
            p1.setStrength(2);
        }

        // 6-3
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 3 – Assassin: The lower strength wins instead.
            p2.setHoldOneRound(true);
            checkPoints(p1, c2, p2, c1, r);
            // 6 – General: The next card you play gets +2 strength.
            p1.setStrength(2);
        }

        // 6-2
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            checkPoints(p1, c2, p2, c1, r);
            // 6 – General: The next card you play gets +2 strength.
            p1.setStrength(2);
            // 2 – Spy: Next round, you choose a card after your opponent reveals theirs.
            p2.setPlayLateHand(true);
        }

        // 6-1
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            checkPoints(p1, c2, p2, c1, r);
            // 6 – General: The next card you play gets +2 strength.
            p1.setStrength(2);
            // 1 – Princess: If your opponent plays the Prince you win the whole game.
            // do nothing
        }

        // 6-0
        if (c1.getNumber() == 7 && c2.getNumber() == 6) {
            // 6 – General: The next card you play gets +2 strength.
            p1.setStrength(2);
            // 0 – Musician: This round is on hold.
            holdThisRound(p1, p2, r);
        }

        return r;
    }

    private static void checkPoints(Player p1, Card c1, Player p2, Card c2, Result r) {
        // hint
        if (p1.getStrength() != 0) System.out.println(p1 + "gets +2 strength in this turn.");
        if (p2.getStrength() != 0) System.out.println(p2 + "gets +2 strength in this turn.");
        // check points
        if (p1.getStrength() + c1.getNumber() > p2.getStrength() + c2.getNumber()) {
            // p1 win
            winThisRound(p1, r);
        } else if (p1.getStrength() + c1.getNumber() < p2.getStrength() + c2.getNumber()) {
            // p2 win
            winThisRound(p2, r);
        } else {
            // tie
            r.result = Result.TIE;
        }
        // clear buff
        clearBuff(p1, p2);
    }

    private static void winThisRound(Player p, Result r) {
        r.winner = p;
        if (p.isHoldOneRound()) {
            r.result = Result.PLAYER_ADD_TWO_SCORE;
        } else {
            r.result = Result.PLAYER_ADD_ONE_SCORE;
        }
    }

    private static void winThisGame(Player p, Result r) {
        r.winner = p;
        r.result = Result.PLAYER_WIN_GAME;
    }

    private static void holdThisRound(Player p1, Player p2, Result r) {
        r.result = Result.HOLD;
        p1.setHoldOneRound(true);
        p2.setHoldOneRound(true);
    }

    private static void clearBuff(Player p1, Player p2) {
        // p1
        p1.setStrength(0);
        p1.setHoldOneRound(false);
        p1.setHoldOneRound(false);
        // p2
        p2.setStrength(0);
        p2.setHoldOneRound(false);
        p2.setHoldOneRound(false);
    }
}
