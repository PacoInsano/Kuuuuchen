package SerBinaer16;
import java.io.Serializable;

//To serialize binary the interface Serializable is needed
public class Topping implements Serializable {

	// Version ID needed
	private static final long serialVersionUID = 701L;

	private String name;
	private boolean vegetarian;
	
	public Topping(){
		
	}

	public Topping(String name, boolean vegetarian) {
		this.name = name;
		this.vegetarian = vegetarian;
	}

	public String getName() {
		return this.name;
	}

	public boolean getVegetarian() {
		return this.vegetarian;
	}

}
