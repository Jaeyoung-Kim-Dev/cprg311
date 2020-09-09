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
public class DeserializeUserMessageDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/usermessage.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		UserMessage userMessage = (UserMessage) ois.readObject();
		
		System.out.println(userMessage);
		
		ois.close();
		fis.close();
	}

}
