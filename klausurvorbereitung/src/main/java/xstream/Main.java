package xstream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;

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

		// Initialize Output
//		XStream xstream = new XStream(new DomDriver());
		// Change the name of the tag
//		xstream.aliasField("Diameter", Pizza.class, "size");

		try (FileWriter fw = new FileWriter("XmlXStreamSer.xml")){
//			xstream.toXML(p1, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// // Deserialize ////
		Pizza readObject = null;


		try(FileReader fr = new FileReader("XmlXStreamSer.xml");){
//			readObject = (Pizza) xstream.fromXML(fr); // Read Object
		} catch (IOException e) {
			e.printStackTrace();
		}

		readObject.printPizza();

	}
}
