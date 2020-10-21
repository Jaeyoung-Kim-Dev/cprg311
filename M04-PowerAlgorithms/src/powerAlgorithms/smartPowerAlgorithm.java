package teststuff;

public class smartPowerAlgorithm {

	private static final int BASE = 2;
	private static final int POWER = 6;
	
	public static void main(String[] args)
	{
		int x = 1;
		int y = BASE;
		int z = POWER;
		
		while(z > 0)
		{
			if(z%2==1) x*=y;
			z/=2;
			y*=y;
		}
		System.out.println("Smart answer is: " + x);
	}
}
