package StringListOwnInterface;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AlterView extends JFrame implements Observer {


	private static final long serialVersionUID = 15L;

	private Model model;

	// The components of the view
	private Container contP;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JButton deleteButton;

	public AlterView(Model model) {
		super("Stringliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.model = model;


		// create and add the components
		contP = this.getContentPane();
		contP.setLayout(new BorderLayout());

		list = new JList<>();
		scrollPane = new JScrollPane(list);
		deleteButton = new JButton("Delete");

		contP.add(scrollPane, BorderLayout.CENTER);
		contP.add(deleteButton, BorderLayout.SOUTH);

		this.pack();
		this.setVisible(true);
	}

	/**
	 * The update function of this observer
	 */
	public void update() {
		list.setListData(model.getStrings().toArray(new String[0]));
		this.pack();
	}

	/**
	 * Adds an ActionListener for the inputButton
	 * 
	 * @param a
	 *            The ActionListener
	 */
	public void addActionListener(ActionListener a) {
		deleteButton.addActionListener(a);
	}

}
