/**
 * 
 */
package client;

import problemdomain.Message;

import java.io.*;
import java.net.*;

/**
 * @author nhamnett
 *
 */
public class ServerHandler implements Runnable {
	private ClientGUI gui;
	
	private Socket server;
	private ObjectInputStream ois;
	
	public ServerHandler(ClientGUI gui, Socket server, ObjectInputStream ois) {
		this.gui = gui;
		this.server = server;
		this.ois = ois;
	}


	@Override
	public void run() {
		while (!this.server.isClosed()) {
			try {
				Message receive = (Message) this.ois.readObject();
				this.gui.addMessage(receive.toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
