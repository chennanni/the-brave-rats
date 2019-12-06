package com.north.cardspack;

import com.north.gamecore.Card;

public class Assassin extends Card {
	private final int NUMBER = 3;
	private final String NAME = "Assassin";
	private final String DESCRIPTION ="The lower strength wins instead.";

	public Assassin() {
		super.setNumber(NUMBER);
		super.setName(NAME);
		super.setDescription(DESCRIPTION);
	}
	
	public void magic() {
		// 3 – Assassin: The lower strength wins instead.
	};

}
