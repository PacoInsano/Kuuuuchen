package StringListMulti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDelete implements ActionListener {

	private Model model;
	private ViewDelete view;

	public ControllerDelete() {

	}

	public void actionPerformed(ActionEvent arg0) {
		model.delete();

	}
	
	public void link(Model m, ViewDelete v){
		this.model = m;
		this.model.addObserver(v);
		
		this.view = v;
		view.addActionListener(this);
	}

}
