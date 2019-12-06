package com.north.cardspack;

import com.north.gamecore.Card;

public class Wizard extends Card {
	private final int NUMBER = 5;
	private final String NAME = "Wizard";
	private final String DESCRIPTION ="Nullify your opponents special ability";

	public Wizard() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		// 5 – Wizard: Nullify your opponent’s special ability.
	}

}
