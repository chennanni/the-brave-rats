package com.north.gamecore;

import java.io.IOException;

public class UserInterface {

    public static void printOption(Player p) {
        System.out.println('\n'+"<<<<<<Option>>>>>>");
        System.out.println(p + "'s turn");
        System.out.println("-1: ready to play");
        System.out.println("-2: show my cards in hand");
        System.out.println("-3: show my cards played");
        System.out.println("-4: show opponent's cards played");
        System.out.println("-5: show the score board");
        System.out.println("-6: show the battle history");
        System.out.println("<<<<<<<<<<<<>>>>>>>>>>>"+"\n");
    }

    public static void printCardPlayed(Player p) {
        System.out.println(p + " choosed " + p.getCard().getNumber() + " " + p.getCard().getName() + "." + "\n");
    }

    public static void printScoreBoard(Player p1, Player p2) {
        System.out.println('\n'+"------SCORE BOARD------");
        System.out.println(p1.getName()+": "+p1.getScore());
        System.out.println(p2.getName()+": "+p2.getScore());
        System.out.println("------------------"+"\n");
    }

    public static void printBattleHistory(String history) {
        clearConsole();
        System.out.println('\n'+"------History------");
        if (history==null || history.isEmpty()) {
            System.out.println('\n'+"Empty history..."+'\n');
        } else {
            System.out.println(history);
        }
        System.out.print("------------------"+"\n");
    }

    public static void printBuff(Player player) {
        if (player.getStrength() != 0) UserInterface.println("BUFF: " + player + " gets +2 strength in this round. (General's Magic)");
        if (player.isHoldOneRound()) UserInterface.println("BUFF: " + player + " will add 1 more point if win this turn. (Musician's Magic)");
        if (player.isAddExtraPoint()) UserInterface.println("BUFF: " + player + " will add 1 extra point if win this turn. (Ambassador's Magic)");
    }

    public static void endGame(Player player) {
        System.out.println(player+" win!");
    }
    public static void endGameTie() {
        System.out.println("Tie this game!");
    }

    public static void clearConsole() {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            //Runtime.getRuntime().exec("cls");
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            //Runtime.getRuntime().exec("clear");
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        System.out.println(string);
    }
}
