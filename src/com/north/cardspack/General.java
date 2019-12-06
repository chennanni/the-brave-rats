package com.north.cardspack;

import com.north.gamecore.Card;

public class General  extends Card {
	private final int NUMBER = 6;
	private final String NAME = "General";
	private final String DESCRIPTION ="The next card you play gets +2 strength.";

	public General() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}

	public void magic() {
		// 6 – General: The next card you play gets +2 strength.
	};

}
