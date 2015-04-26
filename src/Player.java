import java.util.Iterator;

import CardsPack.Card;
import CardsPack.Deck;

public class Player {
	Deck deck;
	int score;
	boolean winFlag;
	String name;
	
	public Player(String name) {
		deck = new Deck();
		score = 0;
		winFlag = false;
		this.name = name;
	}
	
	public boolean haveThisCard(int cardNum) {
		for (int i=0; i<deck.cards.size(); i++) {
			if (deck.cards.get(i).getNumber() == cardNum) {
				deck.cardOut(deck.cards.get(i));
				return true;
			}
		}
		return false;
	}
	
	public void printAllCards() {
		Iterator<Card> ite = deck.cards.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.print("Choose Wisely!"+'\n');
	}
	
	public void printUsedCards() {
		System.out.println("~ "+name+": Used Cards:");
		Iterator<Card> ite = deck.usedCards.iterator();
		if (ite.hasNext()){
			while (ite.hasNext()) {
				System.out.println("~ "+ite.next());
			}
		} else {
			System.out.println("~ No cards have been used!");
		}

	}
	
	public String toString() {
		return this.name;
	}

}
