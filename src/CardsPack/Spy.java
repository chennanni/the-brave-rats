package CardsPack;

public class Spy extends Card {
	final int number = 2;
	final String name = "Spy";
	final String description ="Next round, you choose a card after your opponent reveals theirs.";
	
	Spy() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}
	
	public final void magic() {
		//TODO
	};
	
}
