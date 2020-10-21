package teststuff;

public class simplePowerAlgorithm {

	private static final int BASE = 2;
	private static final int POWER = 8;
	
	public static void main(String[] args)
	{
		int x = 1;
		
		for(int i=0; i<POWER; i++)
		{
			x*=BASE;
		}
		System.out.println("Simple answer is: " + x);
	}
}
