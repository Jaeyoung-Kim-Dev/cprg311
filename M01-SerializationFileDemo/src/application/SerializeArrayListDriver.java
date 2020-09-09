/**
 * 
 */
package application;

import problemdomain.*;

import java.io.*;
import java.util.*;

/**
 * @author Nick Hamnett
 * @version 2019-07-16
 *
 */
public class SerializeArrayListDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/arraylist.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		ArrayList<Integer> nums = new ArrayList<>();
		
		nums.add(1);
		nums.add(2);
		
		oos.writeObject(nums);
		
		System.out.println("Wrote to stream.");
		
		oos.close();
		fos.close();
	}

}
