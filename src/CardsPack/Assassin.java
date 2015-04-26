package CardsPack;

public class Assassin extends Card {
	final int number = 3;
	final String name = "Assassin";
	final String description ="The lower strength wins instead.";

	Assassin() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}
	
	public final void magic() {
		//TODO
	};

}
