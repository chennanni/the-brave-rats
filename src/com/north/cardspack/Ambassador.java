package com.north.cardspack;

public class Ambassador extends Card {
	private final int NUMBER = 4;
	private final String NAME = "Ambassador";
	private final String DESCRIPTION ="If you win, it counts as 2 rounds.";
	
	Ambassador() {
		super.setNumber(NUMBER);
		super.setName(NAME);
		super.setDescription(DESCRIPTION);
	}

	public void magic() {
		System.out.println("I'm a Ambassador, magic!");
	}	
}
