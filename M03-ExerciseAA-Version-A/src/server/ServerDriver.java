package server;

import java.io.*;
import java.net.*;

import problemdomain.Message;

public class ServerDriver {

	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(1234);
		
		System.out.println("Waiting for connection port 1234...");
		
		while (listener.isBound()) {
			try {
				Socket client = listener.accept();
				
				System.out.println("Client connected.");
				
				InputStream inputStream = client.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				
				OutputStream outputStream = client.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				
				System.out.println("Waiting for messages...");
				
				while (client.isConnected()) {
					Message message = (Message) objectInputStream.readObject();
					
					System.out.println("Received message: " + message.toString());
					
					//Message send = new Message("Server", "Okay!");
					//objectOutputStream.writeObject(send);
					
					if (message.getMessage().equalsIgnoreCase("goodbye")) {
						Message byeMessage = new Message("Server", "Bye!");
						objectOutputStream.writeObject(byeMessage);
						
						client.close();
						break;
					}
				}
			} catch (IOException ex) {
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		listener.close();
	}

}
