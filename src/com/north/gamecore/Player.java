package com.north.gamecore;
import java.util.Iterator;

public class Player {
    // Opponent
    private Player opponent;
	// hold cards
	private Deck deck;
    // card choosen
    private Card card;
	// basic info
	private String name;
	private int score;
	private boolean winFlag;
	// buff
	private int strength;
	private boolean playLateHand;
	private boolean holdOneRound;
	private boolean addExtraPoint;

	public Player(String name) {
		setDeck(new Deck());
		setName(name);
		setScore(0);
		setWinFlag(false);
		clearBuff();
	}

	public void clearBuff() {
		setStrength(0);
		setPlayLateHand(false);
		setHoldOneRound(false);
		setAddExtraPoint(false);
	}

	/**
	 * 1. judge if player's deck has this card
	 * 2. if true, remove this card from the deck
	 * @param cardNum number of the chosen card
	 * @return true/false: if have this specific card
	 */
	public boolean haveThisCard(int cardNum) {
		for (int i=0; i<getDeck().getCards().size(); i++) {
			if (getDeck().getCards().get(i).getNumber() == cardNum) {
				getDeck().cardOut(getDeck().getCards().get(i));
				return true;
			}
		}
		return false;
	}

    /**
     * show all cards available, similar to printNotUsedCards
     */
	public void printAllCards() {
		Iterator<Card> ite = getDeck().getCards().iterator();
		while (ite.hasNext()) {
            UserInterface.println(ite.next().toString());
		}
		UserInterface.print("Choose Wisely!"+'\n');
	}

    /**
     * show all cards played
     */
	public void printUsedCards() {
        UserInterface.clearConsole();
		UserInterface.println("\n"+"------"+getName()+"'s Used Cards------");
		Iterator<Card> ite = getDeck().getUsedCards().iterator();
		if (ite.hasNext()){
			while (ite.hasNext()) {
                UserInterface.println("~ "+ite.next().toString());
			}
		} else {
            UserInterface.println("~ No cards have been used!");
		}
        UserInterface.println("------------------"+"\n");
	}

    /**
     * show all cards not played
     */
	public void printNotUsedCards() {
        UserInterface.clearConsole();
        UserInterface.println("\n"+"------"+getName()+"'s Not Used Cards------");
		Iterator<Card> ite = getDeck().getCards().iterator();
		if (ite.hasNext()){
			while (ite.hasNext()) {
                UserInterface.println("~ "+ite.next().toString());
			}
		}
        UserInterface.println("------------------"+"\n");
	}

    /**
     * show all exposed cards
     */
    public void printExposedCards() {
        UserInterface.clearConsole();
        UserInterface.println("\n"+"------"+getName()+"'s Exposed Cards------");
        Iterator<Card> ite = getDeck().getExposedCards().iterator();
        if (ite.hasNext()){
            while (ite.hasNext()) {
                UserInterface.println("~ "+ite.next().toString());
            }
        } else {
            UserInterface.println("~ No cards have been played!");
        }
        UserInterface.println("------------------"+"\n");
    }

	public String toString() {
		return this.getName();
	}

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isWinFlag() {
		return winFlag;
	}

	public void setWinFlag(boolean winFlag) {
		this.winFlag = winFlag;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public boolean isPlayLateHand() {
		return playLateHand;
	}

	public void setPlayLateHand(boolean playLateHand) {
		this.playLateHand = playLateHand;
	}

	public boolean isHoldOneRound() {
		return holdOneRound;
	}

	public void setHoldOneRound(boolean holdOneRound) {
		this.holdOneRound = holdOneRound;
	}

	public boolean isAddExtraPoint() {
		return addExtraPoint;
	}

	public void setAddExtraPoint(boolean addExtraPoint) {
		this.addExtraPoint = addExtraPoint;
	}

}
