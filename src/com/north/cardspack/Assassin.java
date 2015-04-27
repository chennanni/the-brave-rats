package com.north.cardspack;

public class Assassin extends Card {
	private final int NUMBER = 3;
	private final String NAME = "Assassin";
	private final String DESCRIPTION ="The lower strength wins instead.";

	Assassin() {
		super.setNumber(NUMBER);
		super.setName(NAME);
		super.setDescription(DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};

}
