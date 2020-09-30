/**
 * Created on Sep 20, 2018
 * Modified on Jun 22, 2019
 *
 * Project: demo05-ObserverPattern
 */
package propertyChangeEventListener;

/**
 * @author kitty
 * @version 1.1
 */
public class Valve
{
	private int ID;
	//Constants
	private final int LOWERBOUND = 50;
	private final int UPPERBOUND = 100;
	
	public Valve(int ID)
	{
		this.ID = ID;
	}
	
	
	public void setNewValue(int CID, int oldValue, int newValue)
	{
		if(newValue < LOWERBOUND)
		{
			System.out.println("Controller "+CID+", Valve "+ID+
					": Closing valve, pressure changed from "+
					oldValue+" to "+newValue);
		}
		else if(newValue > UPPERBOUND)
		{
			System.out.println("Controller "+CID+", Valve "+ID+
					": Opening valve, pressure changed from "+
					oldValue+" to "+newValue);
		}
		else
		{
			System.out.println("Controller "+CID+", Valve "+ID+
					": Pressure normal at "+newValue);
		}
	}
}
