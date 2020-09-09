package application;

import java.io.*;
import java.util.*;
import java.net.*;

import problemdomain.Message;

public class ClientDriver {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		System.out.print("Connecting to server... ");
		
		Socket socket = new Socket("127.0.0.1", 1234);
		
		System.out.println("Connected!");
		System.out.println();
		
		OutputStream outputStream = socket.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		while (socket.isConnected()) {
			System.out.print("Enter message: ");
			String message = in.nextLine();
			
			Message messageObj = new Message(message);
			objectOutputStream.writeObject(messageObj);
			
			System.out.println("Sent message!");
		}
		
		System.out.println("Goodbye.");
		
		socket.close();
		in.close();
	}
}
