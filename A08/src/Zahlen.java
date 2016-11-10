import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 
 */

/**
 * @author Georg Reisinger
 * @version 10.11.2016
 *
 */
public class Zahlen implements IZahlen {
	private HashSet<Double> value;

	/**
	 * 
	 */
	public Zahlen() {
		value = new HashSet<Double>();
	}

	/**
	 * Berechnet die Summe von allen hinzugefügten Zahlen.
	 * 
	 * @return Die Summe aller Zahlen.
	 */
	@Override
	public double getSumme() {
		double summe = 0;
		Iterator<Double> i = value.iterator();
		while (i.hasNext()) {
			summe += i.next();
		}
		return summe;
	}

	/**
	 * Gibt das Minimumm allen hinzugefügten Zahlen aus.
	 * 
	 * @return Kleinste Zahl
	 */
	@Override
	public double getMinimum() {
		Iterator<Double> i = value.iterator();
		return i.next();
	}

	/**
	 * Gibt das Maximum aller hinzugefügten Zahlen aus.
	 * 
	 * @return Größte Zahl
	 */
	@Override
	public double getMaximum() {
		Iterator<Double> i = value.iterator();
		for(int j = 0; j < value.size(); j++){
			if( j == value.size()){
				return i.next();
			}
		}
		return 0;
	}

	@Override
	public void add(double value) {
		this.value.add(value);
	}

}
