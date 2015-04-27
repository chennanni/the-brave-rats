package com.north.cardspack;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		cards.add(new Musician());
		cards.add(new Princess());
		cards.add(new Spy());
		cards.add(new Assassin());
		cards.add(new Ambassador());
		cards.add(new Wizard());
		cards.add(new General());
		cards.add(new Prince());
	}
	
	public void cardOut(Card thisCard) {
		cards.remove(thisCard);
		usedCards.add(thisCard);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public ArrayList<Card> getUsedCards() {
		return usedCards;
	}
	public void setUsedCards(ArrayList<Card> usedCards) {
		this.usedCards = usedCards;
	}
}
