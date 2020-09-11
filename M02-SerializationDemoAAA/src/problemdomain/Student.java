/**
 * 
 */
package problemdomain;

import java.io.Serializable;

import exceptions.InvalidNameException;

/**
 * Represents a student.
 * @author nhamnett
 *
 */
public class Student implements Serializable {
	private String name;
	
	private long id;
	
	private String program;
	
	/**
	 * Constructor for a Student
	 * @param id Student ID
	 * @param name Student name
	 * @throws InvalidNameException 
	 */
	public Student(long id, String name) throws InvalidNameException {
		this.setId(id);
		this.setName(name);
	}

	/**
	 * Gets the ID
	 * @return Student ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the ID
	 * @param id Student ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name
	 * @return Student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param name Student name
	 */
	public void setName(String name) throws InvalidNameException {
		if (name == null || name.length() == 0)
			throw new InvalidNameException();
		
		this.name = name;
	}

	/**
	 * Gets the program
	 * @return Program student is in.
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * Sets the program
	 * @param program Program student is in.
	 */
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String toString() {
		String formatted = String.format("ID: %d, Name: %s, Program: %s", this.id, this.name, this.program);
		return formatted;
	}
}
