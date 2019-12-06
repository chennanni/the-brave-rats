package com.north.cardspack;

import com.north.gamecore.Card;

public class Prince extends Card {
	private final int NUMBER = 7;
	private final String NAME = "Prince";
	private final String DESCRIPTION ="You win the round.";

	public Prince() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		// 7 – Prince: You win the round.
	};

}
