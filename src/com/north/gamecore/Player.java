package com.north.gamecore;
import java.util.Iterator;

import com.north.cardspack.Card;
import com.north.cardspack.Deck;

public class Player {
	private Deck deck;
	private String name;
	private int score;
	private boolean winFlag;

	public Player() {}
	
	public Player(String name) {
		setDeck(new Deck());
		setScore(0);
		setWinFlag(false);
		this.setName(name);
	}
	
	/**
	 * 1. judge if player's deck has this card
	 * 2. if true, remove this card from the deck
	 * @param card number of the chosen card
	 * @return true/false: if have this specific card
	 */
	public boolean haveThisCard(int cardNum) {
		for (int i=0; i<getDeck().getCards().size(); i++) {
			if (getDeck().getCards().get(i).getNumber() == cardNum) {
				getDeck().cardOut(getDeck().getCards().get(i));
				return true;
			}
		}
		return false;
	}
	
	public void printAllCards() {
		Iterator<Card> ite = getDeck().getCards().iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.print("Choose Wisely!"+'\n');
	}
	
	public void printUsedCards() {
		System.out.println("~ "+getName()+"'s Used Cards:");
		Iterator<Card> ite = getDeck().getUsedCards().iterator();
		if (ite.hasNext()){
			while (ite.hasNext()) {
				System.out.println("~ "+ite.next());
			}
		} else {
			System.out.println("~ No cards have been used!");
		}

	}
	
	public String toString() {
		return this.getName();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isWinFlag() {
		return winFlag;
	}

	public void setWinFlag(boolean winFlag) {
		this.winFlag = winFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
