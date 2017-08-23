package beans;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IntrospectionException {

		// // Create Objects ////

		ArrayList<Topping> toppingList = new ArrayList<Topping>();
		Topping t1 = new Topping("Cheese", true);
		Topping t2 = new Topping("Salami", false);
		toppingList.add(t1);
		toppingList.add(t2);
		// Object to serialize
		Pizza p1 = new Pizza("Salami", 5.50, 23, toppingList);

		// // To make attributes transient ////

		BeanInfo info = Introspector.getBeanInfo(Pizza.class);
		PropertyDescriptor[] propertyDescriptors = info
				.getPropertyDescriptors();

		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor pd = propertyDescriptors[i];
			if (pd.getName().equals("size")) {
				pd.setValue("transient", true);
			}
		}

		// // Serialize ////

		// Initialize OutputStreams

		try (FileOutputStream fo = new FileOutputStream("XmlBeanSer.xml");
				XMLEncoder encoder = new XMLEncoder(fo)) {
			encoder.writeObject(p1); // write Object
			encoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// // Deserialize ////

		Pizza readObject = null;

		try (FileInputStream fi = new FileInputStream("XmlBeanSer.xml");
				XMLDecoder decoder = new XMLDecoder(fi)) {
			readObject = (Pizza) decoder.readObject(); // Read Object
		} catch (IOException e) {
			e.printStackTrace();
		}

		readObject.printPizza();

	}
}
