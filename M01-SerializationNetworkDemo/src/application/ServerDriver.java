package application;

import java.io.*;
import java.net.*;

import problemdomain.Message;

/**
 * @author Nick Hamnett
 * @version 2019-07-15
 *
 */
public class ServerDriver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(1234);
		
		System.out.println("Waiting for connection port 1234...");
		
		while (listener.isBound()) {
			try {
				Socket client = listener.accept();
				
				System.out.println("Client connected.");
				
				InputStream inputStream = client.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				
				System.out.println("Waiting for messages...");
				
				while (client.isConnected()) {
					Message message = (Message) objectInputStream.readObject();
					
					System.out.println("Received message: " + message.toString());
				}
			} catch (IOException ex) {
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		listener.close();

	}

}
