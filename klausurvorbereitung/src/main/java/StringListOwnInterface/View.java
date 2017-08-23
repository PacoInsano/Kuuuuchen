package StringListOwnInterface;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class View extends JFrame implements Observer {

	private Model model;

	// The components of the view
	private Container contP;
	private Container inputC;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JButton inputButton;
	private JTextPane inputPane;

	public View(Model model) {
		super("Stringliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.model = model;


		// create and add the components
		contP = this.getContentPane();
		contP.setLayout(new BorderLayout());

		inputButton = new JButton("Enter");
		inputPane = new JTextPane();
		inputPane.setPreferredSize(new Dimension(200, 20));

		inputC = new Container();
		inputC.setLayout(new FlowLayout());
		inputC.add(inputPane);
		inputC.add(inputButton);

		list = new JList<>();
		scrollPane = new JScrollPane(list);

		contP.add(scrollPane, BorderLayout.CENTER);
		contP.add(inputC, BorderLayout.SOUTH);

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
		inputButton.addActionListener(a);
	}

	/**
	 * @return The Value of the inputPane
	 */
	public String getInputPaneText() {
		return inputPane.getText();
	}

}
