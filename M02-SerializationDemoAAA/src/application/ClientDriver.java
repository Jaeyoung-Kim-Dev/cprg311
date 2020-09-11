/**
 * 
 */
package application;

import java.io.*;
import java.net.*;
import java.util.*;

import exceptions.InvalidNameException;
import problemdomain.*;

/**
 * @author nhamnett
 *
 */
public class ClientDriver {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws InvalidNameException 
	 */
	public static void main(String[] args) throws IOException, InvalidNameException {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter IP address: ");
		String ip = in.nextLine();
		
		System.out.print("Enter port: ");
		int port = in.nextInt();
		
		Socket server = new Socket(ip, port);
		
		System.out.print("Enter ID: ");
		long id = in.nextLong();
		
		in.nextLine();
		
		System.out.print("Enter name: ");
		String name = in.nextLine();
		
		System.out.print("Enter program: ");
		String program = in.nextLine();
		
		Student student = new Student(id, name);
		student.setProgram(program);
		
		OutputStream outputStream = server.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		objectOutputStream.writeObject(student);
		
		System.out.println("Sent student to client.");
		
		objectOutputStream.close();
		outputStream.close();
		
		server.close();
	}

}
