import java.util.Scanner;

import CardsPack.Card;
import CardsPack.Deck;


public class Board {
	Player p1;
	Player p2;
	
	Card cardOfP1;
	Card cardOfP2;
	
	Deck deck;
	
	int countRound;
	
	Scanner in = new Scanner(System.in);
	
	public Board() {
		countRound = 0;
		deck = new Deck();
	}
	
	public void startNewGame() {
		createTwoPlayer();
		
		while (!p1.winFlag && !p2.winFlag && (countRound < 8)) {
			System.out.println("------NEW ROUND------");
			countRound++;
			cardOfP1 = playOneRound(p1);
			cardOfP2 = playOneRound(p2);
			judge();
			System.out.println("------END ROUND------");
			printScoreBoard();
		}
		
		if (p1.winFlag) {
			endGame(p1);
		} else if (p2.winFlag) {
			endGame(p2);
		} else {
			endGameTie();
		}
	}
	
	private void createTwoPlayer() {
		p1 = new Player("P1");
		p2 = new Player("P2");
	}
	
	private Card playOneRound(Player player) {
		// player chooses one card, put on the table
		player.printUsedCards();
		System.out.println(player.name+": Please choose one card, enter a number from 0-7:");
		player.printAllCards();
		// get player's card number
		int num = Integer.valueOf(in.nextLine());
		Card playersCard = null;
		switch (num) {
		case 0 : playersCard = deck.cards.get(0); break;
		case 1 : playersCard = deck.cards.get(1); break;
		case 2 : playersCard = deck.cards.get(2); break;
		case 3 : playersCard = deck.cards.get(3); break;
		case 4 : playersCard = deck.cards.get(4); break;
		case 5 : playersCard = deck.cards.get(5); break;
		case 6 : playersCard = deck.cards.get(6); break;
		case 7 : playersCard = deck.cards.get(7); break;
		default: System.out.println("Input err, please choose from 0-7!"); return playOneRound(player);
		}
		if (player.haveThisCard(num))
			return playersCard;
		else {
			System.out.println("Input err, please choose a NOT USED card!");
			return playOneRound(player);
		}
	}
	
	private void judge() {
		System.out.println("******judging******");
		if (cardOfP1.getNumber() > cardOfP2.getNumber()) {
			p1.score++;
			System.out.println(p1.name+" win this round!");
		} else if (cardOfP1.getNumber() < cardOfP2.getNumber()) {
			p2.score++;
			System.out.println(p2.name+" win this round!");
		} else {
			System.out.println("Tie...");
		}
		
		if (p1.score >=4) {
			p1.winFlag = true;
		} else if (p2.score >=4) {
			p2.winFlag = true;
		}
		//System.out.println("\n");
	}
	
	private void printScoreBoard() {
		System.out.println("<<<<<<SCORE BOARD>>>>>>");
		System.out.println(p1.name+": "+p1.score);
		System.out.println(p2.name+": "+p2.score);
		System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>");
	}
	
	private void endGame(Player player) {
		System.out.println(player+" win!");
	}
	private void endGameTie() {
		System.out.println("Tie this game!");
	}
}
