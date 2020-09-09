package application;

import java.io.*;

import domainmodel.Student;

public class AppDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("res/student.bin");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Student student = (Student) ois.readObject();
		
		System.out.println(student);
		
		ois.close();
		fis.close();
	}

}
