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
public class SerializeMessageExternDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/messageextern.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		MessageExtern message = new MessageExtern("Hello!");
		
		oos.writeObject(message);
		
		System.out.println("Wrote to stream.");
		
		oos.close();
		fos.close();
	}

}
