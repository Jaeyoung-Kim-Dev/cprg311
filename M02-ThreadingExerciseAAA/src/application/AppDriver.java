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
public class AppDriver {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		NumberEntries numEntries = new NumberEntries();
		Thread[] threads = new Thread[4];
		
		for (int n = 1; n <= 4; n++) {
			String id = String.format("Thread %d", n);
			NumberEntryHandler numEntryHandler = new NumberEntryHandler(id, numEntries);
			threads[n - 1] = new Thread(numEntryHandler);
			
			threads[n - 1].start();
		}
		
		for (Thread thread : threads) {
			thread.join();
		}
		
		for (NumberEntry numEntry : numEntries.all()) {
			System.out.println(numEntry);
		}
	}

}
