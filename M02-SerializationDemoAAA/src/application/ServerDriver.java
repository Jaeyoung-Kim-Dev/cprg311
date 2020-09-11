/**
 * 
 */
package application;

import java.util.*;

import exceptions.InvalidNameException;
import problemdomain.Student;

import java.net.*;
import java.io.*;

/**
 * @author nhamnett
 *
 */
public class ServerDriver {

	/**
	 * @param args
	 * @throws InvalidNameException 
	 */
	public static void main(String[] args) throws IOException, InvalidNameException {
		ServerSocket listener = new ServerSocket(5555);
		
		
		
		while (listener.isBound()) {
			System.out.println("Waiting for connection... ");
			
			Socket client = listener.accept();
			
			System.out.println("Client connected.");
			
			/*ClientHandler clientHandler = new ClientHandler(client);
			Thread clientThread = new Thread(clientHandler);
			
			clientThread.start();*/
			
			ClientHandlerThread clientHandlerThread = new ClientHandlerThread(client);
			clientHandlerThread.start();
			
			//clientThread.interrupt();
		}
		
		listener.close();
	}

}
