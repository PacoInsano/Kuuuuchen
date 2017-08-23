package Deep;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Point> points = new ArrayList<Point>();
		// Add Points into Array List
		points.add(new Point(2, 2));
		points.add(new Point(2, 2));
		points.add(new Point(2, 2));

		// Printing the ArrayLists
		System.out.println("Original:");
		for (Point p : points) {
			p.printPoint();
		}
		
		// Creating a flat copy of the ArrayList
		ArrayList<Point> flatCopy = (ArrayList<Point>) points.clone();
		// Creating a deep copy of the ArrayList
		ArrayList<Point> deepCopy = null;
		
		// copy by own function
		deepCopy = deepCopyByOwnFunction(points);
		
		// Deep Copy by serialization (may throw exception!)
//		try {
//			 // // copy by file
//			//deepCopy = (ArrayList<Point>) deepCopyByFile(points);
//			 // //copy in byte array
//			//deepCopy = (ArrayList<Point>) deepCopyBuffered(points);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println("Modify data!");
		
		// Change the x value of the original of the first point
		points.get(0).x = 5;


		// Printing the ArrayLists
		System.out.println("Original modified:");
		for (Point p : points) {
			p.printPoint();
		}

		System.out.println("flatCopy:");
		for (Point p : flatCopy) {
			p.printPoint();
		}

		System.out.println("deepCopy:");
		for (Point p : deepCopy) {
			p.printPoint();
		}
	}

	private static ArrayList<Point> deepCopyByOwnFunction(ArrayList<Point> points) {
		System.out.println("Use Deep Copy by own function!");
		ArrayList<Point> listCopy = new ArrayList<Point>();
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			Point pCopy = new Point(p.x, p.y);
			listCopy.add(pCopy);
		}
		return listCopy;
	}


	public static Object deepCopyByFile(Object o) throws IOException {
		System.out.println("Use Deep Copy by file!");
		try (FileOutputStream fos = new FileOutputStream("tmpObj");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(o);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object deepCpy = null;
		// Deserialize object
		try (FileInputStream fis = new FileInputStream("tmpObj");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			deepCpy = (Object) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return deepCpy;
	}
	

	public static Object deepCopyBuffered(Object o) throws IOException {
		System.out.println("Use Deep Copy by byte array!");
		// Serialize object
		byte[] daten = null;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(o);
			oos.flush();
			daten = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object deepCpy = null;

		// Deserialize object
		try (ByteArrayInputStream bin = new ByteArrayInputStream(daten);
				ObjectInputStream ois = new ObjectInputStream(bin)) {

			deepCpy = (Object) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return deepCpy;
	}

}
