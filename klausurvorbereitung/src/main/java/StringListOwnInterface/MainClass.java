package StringListOwnInterface;
public class MainClass {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View(model);
		AlterView view2 = new AlterView(model);
		Controller controller = new Controller();
		controller.link(model, view);
		ControllerDelete controller2 = new ControllerDelete();
		controller2.link(model, view2);
		

	}

}
