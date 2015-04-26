package CardsPack;

public class Ambassador extends Card {
	final int number = 4;
	final String name = "Ambassador";
	final String description ="If you win, it counts as 2 rounds.";
	
	Ambassador() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}

	public void magic() {
		//TODO
	}	
}
