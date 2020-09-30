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
public class Coolant
{
	private int ID;
	//Constants
	private final int LOWERBOUND = -75;
	private final int UPPERBOUND = 75;
	
	public Coolant(int ID)
	{
		this.ID = ID;
	}
	
	public void setNewValue(int CID, int oldValue, int newValue)
	{
		if(newValue < LOWERBOUND)
		{
			System.out.println("Controller "+CID+", Coolant "+ID+
					": Shutting off coolant, temperature changed from "+
					oldValue+" to "+newValue);
		}
		else if(newValue > UPPERBOUND)
		{
			System.out.println("Controller "+CID+", Coolant "+ID+
					": Starting up coolant, temperature changed from "+
					oldValue+" to "+newValue);
		}
		else
		{
			System.out.println("Controller "+CID+", Coolant "+ID+
					": Temperature normal at "+newValue);
		}
	}
}
