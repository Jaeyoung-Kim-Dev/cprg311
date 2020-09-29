/**
 * 
 */
package application;

import problemdomain.*;
import java.util.*;

/**
 * @author nhamnett
 *
 */
public class NumberEntryHandler implements Runnable {
	private String id;
	private NumberEntries numEntries;
	
	public NumberEntryHandler(String id, NumberEntries numEntries) {
		this.id = id;
		this.numEntries = numEntries;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			int value = numEntries.getNextValue();
			NumberEntry numEntry = new NumberEntry(value, this.id);
			
			numEntries.addNumEntry(numEntry);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
