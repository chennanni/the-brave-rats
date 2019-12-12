package com.north.gamecore;

import java.util.Scanner;

public class Board {

    // auto initiation fields
    private int countRound;
	private Deck commonDeck;
	private StringBuilder battleHistory;
    private Scanner screen;

    // manually initiation fields
    private Player p1;
    private Player p2;

	public Board() {
		countRound = 0;
        commonDeck = new Deck();
        battleHistory = new StringBuilder();
        screen = new Scanner(System.in);
	}

    public void startNewGameOfPVP(String P1, String P2) {
        p1 = new Player(P1);
        p2 = new Player(P2);
        startNewGame();
    }

    public void startNewGameOfPVP() {
        p1 = new Player("P1");
        p2 = new Player("P2");
        startNewGame();
    }

	public void startNewGameOfPVE() {
        p1 = new Player("P1");
        p2 = new AI("AI");
        startNewGame();
	}

    public void startNewGame() {
	    // set opponents
        p1.setOpponent(p2);
        p2.setOpponent(p1);

        // playing the game
        while (!p1.isWinFlag() && !p2.isWinFlag() && (countRound < 8)) {
            // Start New Round
            startNewRound();
            countRound++;
            // Menu Selection
            if (p1.isPlayLateHand()) {
                choose(p2);
                UserInterface.printCardPlayed(p2);
                p2.getDeck().exposeThisCard(p2.getCard());
                choose(p1);
            } else if (p2.isPlayLateHand()) {
                choose(p1);
                UserInterface.printCardPlayed(p1);
                p1.getDeck().exposeThisCard(p1.getCard());
                choose(p2);
            } else {
                choose(p1);
                choose(p2);
            }
            judge();
            UserInterface.printScoreBoard(p1, p2);
        }

        // end game scenario
        if (p1.isWinFlag()) {
            UserInterface.endGame(p1);
        } else if (p2.isWinFlag()) {
            UserInterface.endGame(p2);
        } else {
            UserInterface.endGameTie();
        }
    }

	private void startNewRound() {
		System.out.println("Press A to start a new round...");
        screen.next();
        UserInterface.clearConsole();
		System.out.println("------NEW ROUND------");
	}

    private void choose(Player player) {
        chooseOption(player);
        chooseOneCard(player);
        UserInterface.clearConsole();
    }

	private void chooseOption(Player player) {
	    // AI will skip option selection
	    if (player instanceof AI) {
	        return;
        }
        // Display Option Menu
        boolean showOptionMenu = true;
        while (showOptionMenu) {
            UserInterface.printOption(player);
            int num = Utils.parseInput(screen.next());
            showOptionMenu = Utils.parseOptionSelection(num, player, battleHistory.toString());
        }
    }

	private void chooseOneCard(Player player) {
	    if (player instanceof AI) {
	        chooseOneCardAI((AI) player);
        } else {
	        chooseOneCardHuman(player);
        }
    }

	private void chooseOneCardHuman(Player player) {
		// player chooses one card, put on the table
        UserInterface.clearConsole();
		System.out.println(player.getName()+"'s turn");
		System.out.println("Please choose one card, available cards: ");
		player.printAllCards();
		// get player's card number
		int num = Utils.parseInput(screen.next());
		Card card = Utils.parseCardSelection(num, player, commonDeck);
		// get the card
		if (card == null) {
		    chooseOneCardHuman(player);
        } else {
		    player.setCard(card);
        }
	}
	
	private void chooseOneCardAI(AI player) {
        UserInterface.clearConsole();
		System.out.println(player.getName()+"'s turn");
		System.out.println(player.getName()+" is choosing cards...");
		int num = player.randomlyPlay();
        Card card = Utils.parseCardSelection(num, player, commonDeck);
        // sleep some time
        Utils.sleep(2);
        if (card == null) {
            chooseOneCardAI(player);
        } else {
            player.setCard(card);
        }
	}
	
	private void judge() {
	    String details = p1.getName() + ":" + p1.getCard().getNumber() + " " + p1.getCard().getName() + " | " + p1.getCard().getDescription()
                + '\n' + " <-> " + '\n'
                + p2.getName() + ":" + p2.getCard().getNumber() + " " + p2.getCard().getName()+ " | " + p2.getCard().getDescription();
	    battleHistory.append('\n'+"Round "+countRound+'\n'+details+'\n');

	    // details
        UserInterface.clearConsole();
        System.out.println('\n'+"------judging------");
		System.out.println(details);

        Utils.sleep(2);

        // expose card
        p1.getDeck().exposeThisCard(p1.getCard());
        p2.getDeck().exposeThisCard(p2.getCard());

		// judge result
		Result r = Rule.battle(p1, p1.getCard(), p2, p2.getCard());

		// execute result
		r.executeResult(p1, p2);
	}

}
