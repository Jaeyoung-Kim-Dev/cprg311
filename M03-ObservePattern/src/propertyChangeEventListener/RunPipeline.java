/**
 * Created on Sep 20, 2018
 * Modified on Jun 22, 2019
 *
 * Project: demo05-ObserverPattern
 */
package propertyChangeEventListener;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kitty
 * @version 1.1
 */
public class RunPipeline
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// two controllers (the observers)
		List<PropertyChangeListener> observers = new ArrayList<>();
		Controller ctrlr1 = new Controller(1);
		observers.add(ctrlr1);
		Controller ctrlr2 = new Controller(2);
		observers.add(ctrlr2);
		
		// one pipe object (the subject) and give it our list of observers
		Pipe pipe = new Pipe(observers);
		
		// testing...
		System.out.println("Change pressure to high:");
		pipe.setPressure(110);
		System.out.println("\nChange pressure to low:");
		pipe.setPressure(29);
		System.out.println("\nChange pressure to normal:");
		pipe.setPressure(75);
		
		System.out.println("\nChange temperature to high:");
		pipe.setTemperature(100);
		System.out.println("\nChange temperature to low:");
		pipe.setTemperature(-100);
		System.out.println("\nChange temperature to normal:");
		pipe.setTemperature(35);
	}
}
