package SerBinaer16;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// // Create Objects ////

		ArrayList<Topping> toppingList = new ArrayList<Topping>();
		Topping t1 = new Topping("Cheese", true);
		Topping t2 = new Topping("Salami", false);
		toppingList.add(t1);
		toppingList.add(t2);
		// Object to serialize
		Pizza p1 = new Pizza("Salami", 5.50, 23, toppingList);

		// // Serialize ////
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream("binSer.ser");
			os = new ObjectOutputStream(fs);
			os.writeObject(p1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// // Deserialize ////
		Pizza readObject = null;
		FileInputStream fi = null;
		ObjectInputStream is = null;

		try {
			fi = new FileInputStream("binSer.ser");
			is = new ObjectInputStream(fi);
			readObject = (Pizza) is.readObject(); // Read Object
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		readObject.printPizza();

	}
}
