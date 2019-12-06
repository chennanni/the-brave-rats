package com.north.cardspack;

import com.north.gamecore.Card;

public class Musician extends Card {
	private final int NUMBER = 0;
	private final String NAME = "Musician";
	private final String DESCRIPTION ="This round is on hold.";

	public Musician() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		// 0 – Musician: This round is on hold.
	}

}
