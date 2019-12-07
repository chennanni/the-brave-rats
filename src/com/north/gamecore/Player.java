package com.north.gamecore;
import java.util.Iterator;

public class Player {
	// hold cards
	private Deck deck;
	// basic info
	private String name;
	private int score;
	private boolean winFlag;
	// buff
	private int strength;
	private boolean playLateHand;
	private boolean holdOneRound;
	private boolean addExtraPoint;

	public Player() {}
	
	public Player(String name) {
		setDeck(new Deck());
		setName(name);
		setScore(0);
		setWinFlag(false);
		setStrength(0);
		clearBuff();
	}

	public void clearBuff() {
		setStrength(0);
		setPlayLateHand(false);
		setHoldOneRound(false);
		setAddExtraPoint(false);
	}

	/**
	 * 1. judge if player's deck has this card
	 * 2. if true, remove this card from the deck
	 * @param cardNum number of the chosen card
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public boolean isPlayLateHand() {
		return playLateHand;
	}

	public void setPlayLateHand(boolean playLateHand) {
		this.playLateHand = playLateHand;
	}

	public boolean isHoldOneRound() {
		return holdOneRound;
	}

	public void setHoldOneRound(boolean holdOneRound) {
		this.holdOneRound = holdOneRound;
	}

	public boolean isAddExtraPoint() {
		return addExtraPoint;
	}

	public void setAddExtraPoint(boolean addExtraPoint) {
		this.addExtraPoint = addExtraPoint;
	}

}
