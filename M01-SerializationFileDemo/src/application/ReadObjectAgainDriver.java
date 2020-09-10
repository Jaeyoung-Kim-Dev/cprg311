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
public class ReadObjectAgainDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/sb.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		StringBuilder sb = (StringBuilder) ois.readObject();
		//sb = (StringBuilder) ois.readObject();
		
		System.out.println(sb);
		
		ois.close();
		fis.close();
	}

}
