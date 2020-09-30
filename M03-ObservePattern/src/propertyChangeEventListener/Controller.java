/**
 * Created on Sep 20, 2018
 * Modified on Jun 22, 2019
 *
 * Project: demo05-ObserverPattern
 */
package propertyChangeEventListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * @author kitty
 * @version 1.1
 */
public class Controller implements PropertyChangeListener
{
	// each controller has a unique identifier, 2 valves and 1 cooling system to control
	public int ID;
	private Valve v1 = new Valve(1);
	private Valve v2 = new Valve(2);
	private Coolant c1 = new Coolant(1);

	public Controller(int id)
	{
		this.ID = id;
	}

	public void propertyChange(PropertyChangeEvent event)
	{
		String propertyChanged = (String)event.getPropertyName();
		int oldValue = (Integer)event.getOldValue();
		int newValue = (Integer)event.getNewValue();
		
		if(propertyChanged.equals("Pressure"))
		{			
			v1.setNewValue(ID, oldValue, newValue);
			v2.setNewValue(ID, oldValue, newValue);
		}
		else if (propertyChanged.equals("Temperature"))
		{
			c1.setNewValue(ID, oldValue, newValue);
		}
		else
		{
			// nothing right now, but can be scaled later :D
		}
	}
}
