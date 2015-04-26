package CardsPack;

public class General  extends Card {
	final int number = 6;
	final String name = "General";
	final String description ="The next card you play gets +2 strength.";
	
	General() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}

	public final void magic() {
		//TODO
	};

}
