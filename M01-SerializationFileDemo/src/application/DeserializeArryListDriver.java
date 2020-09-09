/**
 * 
 */
package application;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Nick Hamnett
 * @version 2019-07-16
 *
 */
public class DeserializeArryListDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/arraylist.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		ArrayList<Integer> nums = (ArrayList<Integer>) ois.readObject();
		
		System.out.println(nums);
		
		ois.close();
		fis.close();
	}

}
