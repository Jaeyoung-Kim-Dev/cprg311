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
public class DeserializeMessageExternDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/messageextern.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);

		MessageExtern message = (MessageExtern) ois.readObject();
		
		System.out.println(message);
		
		ois.close();
		fis.close();
	}

}
