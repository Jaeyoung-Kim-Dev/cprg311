/**
 * Created on Sep 20, 2018
 * Modified on Jun 22, 2019
 *
 * Project: demo05-ObserverPattern
 */
package propertyChangeEventListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.List;


/**
 * @author kitty
 * @version 1.1
 */

public class Pipe
{
	private int pressure;
	private int temperature;

	private List<PropertyChangeListener> listeners;
	
	public Pipe(List<PropertyChangeListener> l)
	{
		listeners = l;
		this.pressure = 75;
		this.temperature = 35;		
	}
	
	public int getPressure()
	{
		return pressure;
	}

	public void setPressure(int p)
	{
		notifyListeners("Pressure", this.pressure, p);
		this.pressure = p;
	}
	
	public int getTemperature()
	{
		return temperature;
	}

	public void setTemperature(int t)
	{
		notifyListeners("Temperature", this.temperature, t);
		this.temperature = t;
	}
		
	private void notifyListeners(String property, int oldValue, int newValue)
	{
		for( PropertyChangeListener listener : listeners )
		{
			listener.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}
}
