/**
 * 
 */
package application;

import java.net.*;
import java.io.*;
import java.util.*;
import domainmodel.*;

/**
 * @author nhamnett
 *
 */
public class ServerDriver {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket listener = new ServerSocket(1234);
		
		System.out.println("Listening on port 1234");
		
		while (listener.isBound()) {
			Socket client = listener.accept();
			
			System.out.println("Client connected");
			
			ServerClientHandler serverClientHandler = new ServerClientHandler(client);
			Thread serverClientHandlerThread = new Thread(serverClientHandler);
			
			serverClientHandlerThread.start();
			
		}
		
		listener.close();
	}

}
