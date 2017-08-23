package bintransient;
import java.io.Serializable;

public class Product implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2L;
	private String name;
	private transient String createdBy;    // wird nicht serialisiert
	//private String createdBy;                // wird serialisiert
	private int price;
	
	public Product(String name, String createdBy){
		this.name = name;
		this.createdBy = createdBy;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String creator) {
		this.createdBy = creator;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
