package com.north.cardspack;

public abstract class Card {
	private int number;
	private String name;
	private String description;
	
	public abstract void magic();
	
	public String toString() {
		return "-"+number+" : "+name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
