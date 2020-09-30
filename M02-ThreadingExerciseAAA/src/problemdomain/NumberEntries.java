/**
 * 
 */
package problemdomain;

import java.util.ArrayList;

/**
 * @author nhamnett
 *
 */
public class NumberEntries {
	private ArrayList<NumberEntry> numEntries;
	private int nextValue = 1;
	
	public NumberEntries() {
		this.numEntries = new ArrayList<>();
	}
	
	public ArrayList<NumberEntry> all() {
		return numEntries;
	}
	
	public synchronized int getNextValue() {
		int value = nextValue;
		
		nextValue++;
		
		return value;
	}
	
	public synchronized void addNumEntry(NumberEntry numEntry) {
		numEntries.add(numEntry);
	}
}