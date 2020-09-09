/**
 * 
 */
package application;

import problemdomain.*;

import java.io.*;

/**
 * @author Nick Hamnett
 * @version 2019-07-16
 *
 */
public class SerializeMessageDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/message.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Message message = new Message("Hello!");
		
		oos.writeObject(message);
		
		System.out.println("Wrote to stream.");
		
		oos.close();
		fos.close();
	}

}
