package com.north.cardspack;

public class Princess extends Card {
	private final int NUMBER = 1;
	private final String NAME = "Princess";
	private final String DESCRIPTION ="If your opponent plays the Prince you win the whole game.";
	
	Princess() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};

}
