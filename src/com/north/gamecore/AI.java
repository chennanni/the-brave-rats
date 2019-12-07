package com.north.gamecore;

import java.util.Random;

public class AI extends Player {

	private Random random;
	
	public AI() {
		super.setDeck(new Deck());
		super.setScore(0);
		super.setWinFlag(false);
		super.setName("Computer");
		random = new Random();
	}
	
	public AI(String name) {
		super(name);
		random = new Random();
	}

	public int randomlyPlay() {
		int randomNum = random.nextInt(super.getDeck().getCards().size());
		int cardNum = super.getDeck().getCards().get(randomNum).getNumber();
		super.getDeck().cardOut(super.getDeck().getCards().get(randomNum));
		return cardNum;
	}
	
}
