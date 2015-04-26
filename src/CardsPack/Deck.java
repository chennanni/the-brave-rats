package CardsPack;

import java.util.ArrayList;

public class Deck {
	public ArrayList<Card> cards;
	public ArrayList<Card> usedCards;
	
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
}
