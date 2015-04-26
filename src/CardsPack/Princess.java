package CardsPack;

public class Princess extends Card {
	final int number = 1;
	final String name = "Princess";
	final String description ="If your opponent plays the Prince you win the whole game.";
	
	Princess() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}
	
	public final void magic() {
		//TODO
	};

}
