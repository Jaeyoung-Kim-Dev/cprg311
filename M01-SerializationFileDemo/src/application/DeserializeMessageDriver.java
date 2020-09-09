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
public class DeserializeMessageDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/message.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Message message = (Message) ois.readObject();
		
		System.out.println(message);
		
		ois.close();
		fis.close();
	}

}
