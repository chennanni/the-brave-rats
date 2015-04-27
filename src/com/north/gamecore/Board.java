package com.north.gamecore;
import java.util.Scanner;

import com.north.cardspack.Card;
import com.north.cardspack.Deck;


public class Board {
	private Player p1;
	private Player p2;
	private Card cardOfP1;
	private Card cardOfP2;
	private Deck deck;
	private int countRound;
	private Scanner in = new Scanner(System.in);
	
	public Board() {
		countRound = 0;
		deck = new Deck();
	}
	
	public void startNewGame() {
		createTwoPlayer();
		
		while (!p1.isWinFlag() && !p2.isWinFlag() && (countRound < 8)) {
			System.out.println("------NEW ROUND------");
			countRound++;
			cardOfP1 = chooseOneCard(p1);
			cardOfP2 = chooseOneCardAI((AI)p2);
			judge();
			//System.out.println("------END ROUND------");
			printScoreBoard();
		}
		
		if (p1.isWinFlag()) {
			endGame(p1);
		} else if (p2.isWinFlag()) {
			endGame(p2);
		} else {
			endGameTie();
		}
	}
	
	private void createTwoPlayer() {
		p1 = new Player("P1");
		p2 = new AI();
	}
	
	private Card chooseOneCard(Player player) {
		// player chooses one card, put on the table
		//player.printUsedCards();
		System.out.println(player.getName()+"'s turn");
		System.out.println("Please choose one card, available cards: ");
		player.printAllCards();
		// get player's card number
		int num = Integer.valueOf(in.nextLine());
		Card playersCard = null;
		switch (num) {
		case 0 : playersCard = deck.getCards().get(0); break;
		case 1 : playersCard = deck.getCards().get(1); break;
		case 2 : playersCard = deck.getCards().get(2); break;
		case 3 : playersCard = deck.getCards().get(3); break;
		case 4 : playersCard = deck.getCards().get(4); break;
		case 5 : playersCard = deck.getCards().get(5); break;
		case 6 : playersCard = deck.getCards().get(6); break;
		case 7 : playersCard = deck.getCards().get(7); break;
		default: System.out.println("Input err, please choose from 0-7!"); return chooseOneCard(player);
		}
		if (player.haveThisCard(num)) {
			System.out.println(player+" choosed "+num+"."+"\n");
			return playersCard;
		}
		else {
			System.out.println("Input err, please choose a NOT USED card!");
			return chooseOneCard(player);
		}
	}
	
	private Card chooseOneCardAI(AI player) {
		//player.printUsedCards();
		System.out.println(player.getName()+"'s turn");
		System.out.println(player.getName()+" is choosing cards...");
		int num = player.randomlyPlay();
		Card playersCard = null;
		switch (num) {
		case 0 : playersCard = deck.getCards().get(0); break;
		case 1 : playersCard = deck.getCards().get(1); break;
		case 2 : playersCard = deck.getCards().get(2); break;
		case 3 : playersCard = deck.getCards().get(3); break;
		case 4 : playersCard = deck.getCards().get(4); break;
		case 5 : playersCard = deck.getCards().get(5); break;
		case 6 : playersCard = deck.getCards().get(6); break;
		case 7 : playersCard = deck.getCards().get(7); break;
		default: 
		}
		System.out.println(player+" choosed "+num+"."+"\n");
		return playersCard;
	}
	
	private void judge() {
		System.out.println("******judging******");
		System.out.println(p1.getName()+":"+cardOfP1.getNumber()+" <-> "+p2.getName()+":"+cardOfP2.getNumber());
		if (cardOfP1.getNumber() > cardOfP2.getNumber()) {
			p1.setScore(p1.getScore() + 1);
			System.out.println(p1.getName()+" win this round!"+"\n");
		} else if (cardOfP1.getNumber() < cardOfP2.getNumber()) {
			p2.setScore(p2.getScore() + 1);
			System.out.println(p2.getName()+" win this round!"+"\n");
		} else {
			System.out.println("Tie..."+"\n");
		}
		
		if (p1.getScore() >=4) {
			p1.setWinFlag(true);
		} else if (p2.getScore() >=4) {
			p2.setWinFlag(true);
		}
		//System.out.println("\n");
	}
	
	private void printScoreBoard() {
		System.out.println("<<<<<<SCORE BOARD>>>>>>");
		System.out.println(p1.getName()+": "+p1.getScore());
		System.out.println(p2.getName()+": "+p2.getScore());
		System.out.println("<<<<<<<<<<<<>>>>>>>>>>>"+"\n"+"\n");
	}
	
	private void endGame(Player player) {
		System.out.println(player+" win!");
	}
	private void endGameTie() {
		System.out.println("Tie this game!");
	}
}
