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
public class WriteObjectAgainDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/sb.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		StringBuilder sb = new StringBuilder("a");

		oos.writeObject(sb);

		sb.append("b"); // Changes StringBuilder to “ab”
		
		oos.reset();
		oos.writeObject(sb);

		System.out.println("Wrote to stream.");
		
		oos.close();
		fos.close();
	}

}
