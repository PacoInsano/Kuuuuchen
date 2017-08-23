package StringListOwnInterface;
import java.util.ArrayList;

public class Model{
	private ArrayList<String> strings;
	private ArrayList<Observer> observers;
	
	public Model(){
		strings = new ArrayList<String>();
		observers = new ArrayList<Observer>();
	}
	
	private void informObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}
	
	public void registerObserver(Observer ob){
		this.observers.add(ob);
	}
	
	public void addString(String s){
		strings.add(s);	
		informObservers();
	}
	
	public ArrayList<String> getStrings(){
		return strings;
	}
	
	public void delete(){
		strings.clear();
		informObservers();
	}
	
}
