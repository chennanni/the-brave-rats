package com.north.cardspack;

public class Musician extends Card {
	private final int NUMBER = 0;
	private final String NAME = "Musician";
	private final String DESCRIPTION ="This round is on hold.";
	
	Musician() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};

}
