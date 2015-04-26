package CardsPack;

public class Wizard extends Card {
	final int number = 5;
	final String name = "Wizard";
	final String description ="Nullify your opponent¡¯s special ability";

	Wizard() {
		super.setNumber(this.number);
		super.setName(this.name);
		super.setDescription(this.description);
	}
	
	public final void magic() {
		//TODO
	};

}
