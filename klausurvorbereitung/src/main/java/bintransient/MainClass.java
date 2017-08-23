package bintransient;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		
		Product p = new Product("Cheese", "Ulf");
		// Objekt speichern
		try (FileOutputStream fs = new FileOutputStream("d.ser"); ObjectOutputStream os = new ObjectOutputStream(fs)) {
			os.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Objekt laden
		Product pDeser = null;
		try (FileInputStream fis = new FileInputStream("d.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
			pDeser = (Product) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Name: "+pDeser.getName()+"  CreatedBy: "+pDeser.getCreatedBy());
	}

}
