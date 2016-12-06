package game;

/**
 * 
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dient der Steuerung der Viewklasse
 * 
 * @author Georg Reisinger
 * @version 23.11.2016
 */
public class Controller implements ActionListener {

	private View v;

	/**
	 * Default Konstruktor
	 */
	public Controller() {
		this.v = new View(this);
	}

	/**
	 * ActionListener der View klasse
	 * 
	 * @param e
	 *            ActionEvent der View Klasse
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (v.isButton(e) != -1) {
			v.toggleButtons(v.isButton(e));
			v.setLabel();
		} else if (v.isNewGame(e)) {
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState1Black()) {
			v.setState1(Color.black);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState1Blue()) {
			v.setState1(Color.blue);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState1Green()) {
			v.setState1(Color.green);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState1Red()) {
			v.setState1(Color.red);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState1Yellow()) {
			v.setState1(Color.yellow);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState2Black()) {
			v.setState2(Color.black);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState2Blue()) {
			v.setState2(Color.blue);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState2Green()) {
			v.setState2(Color.green);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState2Red()) {
			v.setState2(Color.red);
			v.addButtons();
			v.init();
		} else if (e.getSource() == v.getColorItemState2Yellow()) {
			v.setState2(Color.yellow);
			v.addButtons();
			v.init();
		}
	}

	/**
	 * Startet das Game
	 * 
	 * @param args
	 *            Wird nicht verwendet
	 */
	public static void main(String[] args) {
		new Controller();
	}

}
