package SerBinaer16;
import java.io.Serializable;
import java.util.ArrayList;

//To serialize binary the interface Serializable is needed
public class Pizza implements Serializable {

	// Version ID needed
	private static final long serialVersionUID = 700L;

	private String name;
	private double price;
	private int size;
	private ArrayList<Topping> toppings;

	public Pizza(){
		
	}
	
	public Pizza(String name, double price, int size,
			ArrayList<Topping> toppings) {
		this.name = name;
		this.price = price;
		this.size = size;
		this.toppings = toppings;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Topping> getToppings() {
		return this.toppings;
	}

	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings = toppings;
	}

	public void printPizza() {
		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
		System.out.println("Size: " + this.size);
		System.out.println("Toppings:");
		for (int i = 0; i < this.toppings.size(); i++) {
			System.out.println(i + 1 + "." + this.toppings.get(i).getName());
		}
	}

}


