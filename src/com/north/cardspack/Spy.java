package com.north.cardspack;

import com.north.gamecore.Card;

public class Spy extends Card {
	private final int NUMBER = 2;
	private final String NAME = "Spy";
	private final String DESCRIPTION ="Next round, you choose a card after your opponent reveals theirs.";

	public Spy() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		// 2 – Spy: Next round, you choose a card after your opponent reveals theirs.
	};

}
