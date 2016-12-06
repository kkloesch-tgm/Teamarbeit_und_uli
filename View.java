package game;
/**
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Die Viewklasse des Games
 * 
 * @author Konrad Klösch
 * @version 22.11.2016
 */
@SuppressWarnings("serial")
public class View extends JFrame {

	private Controller c;
	private Data d;

	private ArrayList<JButton> buttons;
	private JPanel buttonPanel, infoPanel;
	private JLabel currentMoves;

	private JMenuBar infoBar;
	private JMenu gameMenu, helpMenu, colorMenuState1, colorMenuState2;
	private JMenuItem newGameItem;

	private Color buttonColorState1;
	private JMenuItem colorItemState1Green, colorItemState1Blue, colorItemState1Red, colorItemState1Black,
			colorItemState1Yellow;

	private Color buttonColorState2;
	private JMenuItem colorItemState2Green, colorItemState2Blue, colorItemState2Red, colorItemState2Black,
			colorItemState2Yellow;

	/**
	 * Erstellt das Frame und setzt darauf das Panel.s
	 * 
	 * @param c
	 *            Der ActionController
	 */
	public View(Controller c) {
		this.setLayout(new BorderLayout());
		this.c = c;
		this.d = new Data();

		buttonColorState1 = Color.red;
		buttonColorState2 = Color.green;

		infoBar = new JMenuBar();
		gameMenu = new JMenu("Game");
		gameMenu.setMnemonic(KeyEvent.VK_A);
		gameMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		infoBar.add(gameMenu);

		// Color State 1 Menu
		colorMenuState1 = new JMenu("Change Color - State1");
		gameMenu.add(colorMenuState1);

		colorItemState1Green = new JMenuItem("Green");
		colorItemState1Blue = new JMenuItem("Blue");
		colorItemState1Red = new JMenuItem("Red");
		colorItemState1Black = new JMenuItem("Black");
		colorItemState1Yellow = new JMenuItem("Yellow");

		colorMenuState1.add(colorItemState1Green);
		colorMenuState1.add(colorItemState1Blue);
		colorMenuState1.add(colorItemState1Red);
		colorMenuState1.add(colorItemState1Black);
		colorMenuState1.add(colorItemState1Yellow);

		colorItemState1Green.addActionListener(c);
		colorItemState1Blue.addActionListener(c);
		colorItemState1Red.addActionListener(c);
		colorItemState1Black.addActionListener(c);
		colorItemState1Yellow.addActionListener(c);

		// Color state 2 Menu
		colorMenuState2 = new JMenu("Change Color - State2");
		gameMenu.add(colorMenuState2);

		colorItemState2Green = new JMenuItem("Green");
		colorItemState2Blue = new JMenuItem("Blue");
		colorItemState2Red = new JMenuItem("Red");
		colorItemState2Black = new JMenuItem("Black");
		colorItemState2Yellow = new JMenuItem("Yellow");

		colorMenuState2.add(colorItemState2Green);
		colorMenuState2.add(colorItemState2Blue);
		colorMenuState2.add(colorItemState2Red);
		colorMenuState2.add(colorItemState2Black);
		colorMenuState2.add(colorItemState2Yellow);
		colorItemState2Green.addActionListener(c);
		colorItemState2Blue.addActionListener(c);
		colorItemState2Red.addActionListener(c);
		colorItemState2Black.addActionListener(c);
		colorItemState2Yellow.addActionListener(c);

		// Help Menu
		// helpMenu = new JMenu("Help");
		// helpMenu.setMnemonic(KeyEvent.VK_A);
		// helpMenu.getAccessibleContext().setAccessibleDescription("The only
		// menu in this program that has menu items");
		// infoBar.add(helpMenu);

		// Game Menu
		newGameItem = new JMenuItem("New Game", KeyEvent.VK_T);
		gameMenu.add(newGameItem);
		newGameItem.addActionListener(c);

		this.setJMenuBar(infoBar);
		buttonPanel = new JPanel(new GridLayout(5, 5));
		infoPanel = new JPanel();
		currentMoves = new JLabel();

		infoPanel.setPreferredSize(new Dimension(100, 100));
		buttonPanel.setPreferredSize(new Dimension(500, 500));
		this.setSize(new Dimension(500, 700));

		infoPanel.add(currentMoves);

		this.add(infoPanel, BorderLayout.NORTH);
		this.addButtons();
		this.init();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Es werden alle Buttens erstellt. Diese werden in die ArrayList: "buttons"
	 * gespeichert. Jeder Button bekommt als ActionListener den Controller c
	 * zugewiesen. Die Hintergrundfarbe wird auf buttonColorState1 gesetzt.
	 */
	public void addButtons() {
		this.remove(buttonPanel);
		buttonPanel = new JPanel(new GridLayout(5, 5));
		buttonPanel.setPreferredSize(new Dimension(500, 500));
		this.add(buttonPanel, BorderLayout.SOUTH);
		buttons = new ArrayList<JButton>();
		for (int i = 0; i < 25; i++) {
			JButton temp = new JButton();
			temp.setBackground(buttonColorState1);
			temp.setForeground(Color.black);
			buttons.add(temp);
			buttonPanel.add(temp);
			temp.addActionListener(this.c);
		}
	}

	/**
	 * Ueberprueft welcher Button gedrueckt wurde
	 * 
	 * @param e
	 *            ActionEvent welches zu pruefen ist.
	 * @return Stelle des Buttons in der ArrayList: "buttons" an
	 */
	public int isButton(ActionEvent e) {
		int i;
		for (i = 0; i < 25; i++) {
			if (buttons.get(i) == e.getSource()) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Wird ausgefuert wenn ein Button gedrueckt wurde. Es wird ein ein Move
	 * hochgezaehlt.
	 * 
	 * @param i
	 */
	public void toggleButtons(int i) {
		d.addMove();
		toggleButton(i);
		if (i == 0 || i == 5 || i == 10 || i == 15 || i == 20) {

		} else {
			toggleButton(i - 1);
		}

		if (i == 4 || i == 9 || i == 14 || i == 19 || i == 24) {

		} else {
			toggleButton(i + 1);
		}

		if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {

		} else {
			toggleButton(i - 5);
		}

		if (i == 20 || i == 21 || i == 22 || i == 23 || i == 24) {

		} else {
			toggleButton(i + 5);
		}
	}

	/**
	 * Diese Methode faerbt die Buttons je nachdem Ob sie die Farbe des
	 * State1-Attributs haben oder State2
	 * 
	 * @param buttonNumber
	 *            Ist der Button der Eingefaerbt werden soll
	 */
	public void toggleButton(int buttonNumber) {
		if (buttons.get(buttonNumber).getBackground() == buttonColorState2) {
			JButton temp = buttons.get(buttonNumber);
			setGetButtonColor(temp, buttonColorState1, Color.black);
			buttons.add(buttonNumber, temp);
			buttons.remove(buttonNumber + 1);
		} else {
			JButton temp = buttons.get(buttonNumber);
			setGetButtonColor(temp, buttonColorState2, Color.black);
			buttons.add(buttonNumber, temp);
			buttons.remove(buttonNumber + 1);
		}
		buttonPanel.repaint();
	}

	/**
	 * Setzt das Label auf die derzeitigen Zuege, welche in der Data Klasse
	 * gespeichert sind
	 */
	public void setLabel() {
		currentMoves.setText("Moves: " + d.getMoves());
	}

	/**
	 * Initialisiert das Spiel indem es alle Informationen zuruecksetzt
	 */
	public void init() {
		d = new Data();
		this.setLabel();
		System.out.println(this.buttons.size());
		this.pack();
	}

	/**
	 *
	 * Ueberpueft ob das MenuItem "newGameItem" gedrueckt wurde
	 *
	 * @return Gibt true zurueck, wenn der Button gedrueckt wurde
	 */
	public boolean isNewGame(ActionEvent e) {
		if (newGameItem == e.getSource()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param button
	 *            Ist der Button dem die Farben gesetzt werden
	 * @param background
	 *            Farbe Des Buttons
	 * @param Foreground
	 *            Umrandung des Buttons
	 * @return Gibt den "verfaerbten" Button zurueck
	 */
	public JButton setGetButtonColor(JButton button, Color background, Color Foreground) {
		button.setBackground(background);
		button.setForeground(Foreground);
		return button;
	}

	/**
	 * 
	 * @param s1
	 */
	public void setState1(Color s1) {
		buttonColorState1 = s1;
	}

	/**
	 * 
	 * @param s2
	 */
	public void setState2(Color s2) {
		buttonColorState2 = s2;
	}

	/**
	 * @return the colorItemState1Green
	 */
	public JMenuItem getColorItemState1Green() {
		return colorItemState1Green;
	}

	/**
	 * @return the colorItemState1Blue
	 */
	public JMenuItem getColorItemState1Blue() {
		return colorItemState1Blue;
	}

	/**
	 * @return the colorItemState1Red
	 */
	public JMenuItem getColorItemState1Red() {
		return colorItemState1Red;
	}

	/**
	 * @return the colorItemState1Black
	 */
	public JMenuItem getColorItemState1Black() {
		return colorItemState1Black;
	}

	/**
	 * @return the colorItemState1Yellow
	 */
	public JMenuItem getColorItemState1Yellow() {
		return colorItemState1Yellow;
	}

	/**
	 * @return the colorItemState2Green
	 */
	public JMenuItem getColorItemState2Green() {
		return colorItemState2Green;
	}

	/**
	 * @return the colorItemState2Blue
	 */
	public JMenuItem getColorItemState2Blue() {
		return colorItemState2Blue;
	}

	/**
	 * @return the colorItemState2Red
	 */
	public JMenuItem getColorItemState2Red() {
		return colorItemState2Red;
	}

	/**
	 * @return the colorItemState2Black
	 */
	public JMenuItem getColorItemState2Black() {
		return colorItemState2Black;
	}

	/**
	 * @return the colorItemState2Yellow
	 */
	public JMenuItem getColorItemState2Yellow() {
		return colorItemState2Yellow;
	}

}