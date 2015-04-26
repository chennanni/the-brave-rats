package CardsPack;

public class Prince extends Card {
	final int number = 7;
	final String name = "Prince";
	final String description ="You win the round.";

	Prince() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}
	
	public final void magic() {
		//TODO
	};

}
