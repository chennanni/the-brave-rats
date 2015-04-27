package com.north.cardspack;

public class Prince extends Card {
	private final int NUMBER = 7;
	private final String NAME = "Prince";
	private final String DESCRIPTION ="You win the round.";

	Prince() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};

}
