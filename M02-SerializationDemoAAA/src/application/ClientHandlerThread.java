/**
 * 
 */
package application;

import java.io.*;
import java.util.*;
import java.net.*;

import exceptions.*;
import problemdomain.*;

/**
 * @author nhamnett
 *
 */
public class ClientHandlerThread extends Thread {
	private Socket client;
	
	public ClientHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = this.client.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			Student student = (Student) objectInputStream.readObject();
			
			System.out.println(student);
			
			objectInputStream.close();
			inputStream.close();
			
			
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
