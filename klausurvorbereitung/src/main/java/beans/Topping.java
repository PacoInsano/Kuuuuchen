package beans;
public class Topping {

	private String name;
	private boolean vegetarian;

	// Default constructer is needed
	public Topping() {

	}

	public Topping(String name, boolean vegetarian) {
		this.name = name;
		this.vegetarian = vegetarian;
	}

	// // Every attribute needs getter and setter ////

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getVegetarian() {
		return this.vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

}
