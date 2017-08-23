package Deep;
import java.io.Serializable;
public class Point implements Serializable{

	private static final long serialVersionUID = 1092593693045159750L;

	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void printPoint(){
		System.out.println(this.x + "," + this.y);
	}
	
}
