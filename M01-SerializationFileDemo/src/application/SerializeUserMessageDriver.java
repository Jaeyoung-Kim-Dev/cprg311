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
public class SerializeUserMessageDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/usermessage.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		UserMessage userMessage = new UserMessage("Joe Blow", 30, "Hello!");
		
		oos.writeObject(userMessage);
		
		System.out.println("Wrote to stream.");
		
		oos.close();
		fos.close();
	}

}
