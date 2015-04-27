package com.north.cardspack;

public class Wizard extends Card {
	private final int NUMBER = 5;
	private final String NAME = "Wizard";
	private final String DESCRIPTION ="Nullify your opponent¡¯s special ability";

	Wizard() {
		super.setNumber(this.NUMBER);
		super.setName(this.NAME);
		super.setDescription(this.DESCRIPTION);
	}
	
	public void magic() {
		//TODO
	};

}
