package com.north.gamecore;

public class Utils {

    public static boolean parseOptionSelection(int num, Player player, String history) {
        boolean showOptionMenu = true;
        switch(num) {
            case 1:
                // 1: ready to play
                showOptionMenu = false;
                break;
            case 2:
                // 2: show my cards in hand
                player.printNotUsedCards();
                break;
            case 3:
                // 3: show my cards played
                player.printUsedCards();
                break;
            case 4:
                // 4: show opponent's cards played
                player.getOpponent().printExposedCards();
                break;
            case 5:
                // 5: show the score board
                UserInterface.clearConsole();
                UserInterface.printScoreBoard(player, player.getOpponent());
                break;
            case 6:
                // 6: show the battle history
                UserInterface.printBattleHistory(history);
                break;
            default:
                UserInterface.print("Input err, please choose from 1-7!");
                sleep(1);
                UserInterface.clearConsole();
        }
        return showOptionMenu;
    }

    /**
     * given a card num, return the card if available
     * @param num
     * @param player
     * @return
     */
    public static Card parseCardSelection(int num, Player player, Deck CommonDeck) {
        Card playersCard = null;
        if (num>=0 && num<=7) {
            playersCard = CommonDeck.getCards().get(num);
            if (player instanceof AI || player.haveThisCard(num)) { // assume AI will always play right
                return playersCard;
            } else {
                UserInterface.println("Input err, please choose a NOT USED card!");
                sleep(1);
                return null;
            }
        } else {
            UserInterface.println("Input err, please choose from 0-7!");
            sleep(1);
            return null;
        }
    }

    /**
     * parse input String to number, catch exception
     * @param input
     * @return
     */
    public static int parseInput(String input) {
        int num = -1;
        try {
            num = Integer.valueOf(input);
        } catch(Exception e) {
            num = 99;
        }
        return num;
    }

    /**
     * sleep for some time, printing .
     * @param second
     */
    public static void sleep(int second) {
        try {
            for (int i=0; i<second; i++){
                Thread.sleep(1000);
                System.out.println("...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
