
public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseDigits(123456789);
	}

	final static int NUMBER_BASE = 10; // we are working with decimals

	/**
	 * prints the decimal digits of number in reverse order. precondition: number
	 * >=0)
	 */
	public static void reverseDigits(int number) {
		if (number >= 0) {// check for input bounds
			if (number < NUMBER_BASE) // base case
				System.out.print(number);
			else {
				// print out rightmost digit
				System.out.print(number % NUMBER_BASE);
				// pass remainder of digits to next call
				reverseDigits(number / NUMBER_BASE);
			}
		}
	}// reverseDigits()
}
