/**
 * 
 */
package application;

import java.io.*;
import java.net.*;
import domainmodel.Student;

/**
 * @author nhamnett
 *
 */
public class ServerClientHandler implements Runnable {
	private Socket client;
	
	public ServerClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = client.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			OutputStream outputStream = client.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			Student student = (Student) objectInputStream.readObject();
			
			System.out.println(student);
			
			Exception ex = new Exception("Do not panic. This is just a test.");
			objectOutputStream.writeObject(ex);
			
			objectInputStream.close();
			inputStream.close();
			
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
