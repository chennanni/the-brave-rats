package com.north.cardspack;

import com.north.gamecore.Card;

public class Princess extends Card {
	private final int NUMBER = 1;
	private final String NAME = "Princess";
	private final String DESCRIPTION ="If your opponent plays the Prince you win the whole game.";

	public Princess() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		// 1 – Princess: If your opponent plays the Prince you win the whole game.
	};

}
