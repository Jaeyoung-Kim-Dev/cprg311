/**
 * 
 */
package application;

import java.util.*;
import java.io.*;

import domainmodel.Student;

/**
 * @author nhamnett
 *
 */
public class AppDriver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter ID: ");
		long id = in.nextLong();
		
		in.nextLine();
		
		System.out.print("Enter name: ");
		String name = in.nextLine();
		
		System.out.print("Enter program: ");
		String program = in.nextLine();
		
		Student student = new Student(id, name);
		student.setProgram(program);
		
		FileOutputStream fos = new FileOutputStream("res/student.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(student);
		
		/*PrintWriter pw = new PrintWriter(fos);
		
		pw.write("ID: " + id + "\n");
		pw.write("Name: " + name + "\n");
		pw.write("Program: " + program + "\n");
		
		pw.close();*/
		
		oos.close();
		fos.close();
		
		System.out.println(student);
	}

}
