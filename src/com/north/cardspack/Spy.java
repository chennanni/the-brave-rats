package com.north.cardspack;

public class Spy extends Card {
	private final int NUMBER = 2;
	private final String NAME = "Spy";
	private final String DESCRIPTION ="Next round, you choose a card after your opponent reveals theirs.";
	
	Spy() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};
	
}
