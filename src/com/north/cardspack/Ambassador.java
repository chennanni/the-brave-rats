package com.north.cardspack;

import com.north.gamecore.Card;

public class Ambassador extends Card {
	private final int NUMBER = 4;
	private final String NAME = "Ambassador";
	private final String DESCRIPTION ="If you win, it counts as 2 rounds.";
	
	public Ambassador() {
		super.setNumber(NUMBER);
		super.setName(NAME);
		super.setDescription(DESCRIPTION);
	}

	public void magic() {
		// 4 – Ambassador: If you win, it counts as 2 rounds.
	}	
}
