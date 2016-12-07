package game;

/**
 * Dient der Berechnung der benötigten Moves
 * 
 * @author Nemanja Stojicevic
 * @version 21.11.2016
 */
public class Data {

	private int moveCounter;

	/**
	 * Der Movecounter wird auf 0 gesetzt
	 */
	public Data() {
		moveCounter = 0;
	}

	/**
	 * Es wird ein Move hinzugefuegt
	 */
	public void addMove() {
		moveCounter += 1;
	}

	/**
	 * Gibt die anzahl der Moves zurueck
	 * 
	 * @return Anzahl der Moves
	 */
	public int getMoves() {
		return moveCounter;
	}

}
