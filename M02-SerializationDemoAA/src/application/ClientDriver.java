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
public class ClientDriver {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner in = new Scanner(System.in);
		
		String ip = "127.0.0.1";
		
		System.out.print("Enter port: ");
		int port = in.nextInt();
		
		Socket server = new Socket(ip, port);
		
		OutputStream outputStream = server.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		InputStream inputStream = server.getInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		
		System.out.print("Enter ID: ");
		long id = in.nextLong();
		
		in.nextLine();
		
		System.out.print("Enter name: ");
		String name = in.nextLine();
		
		System.out.print("Enter program: ");
		String program = in.nextLine();
		
		Student student = new Student(id, name);
		student.setProgram(program);
		
		objectOutputStream.writeObject(student);
		
		System.out.println("Student object sent.");
		
		try {
			Exception ex = (Exception) objectInputStream.readObject();
			
			System.out.println(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		objectOutputStream.close();
		outputStream.close();
		server.close();
	}

}
