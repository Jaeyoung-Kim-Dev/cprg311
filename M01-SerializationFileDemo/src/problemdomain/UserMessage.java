package problemdomain;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author Nick Hamnett
 * @version 2019-07-15
 *
 */
public class UserMessage implements Serializable {
	static final long serialVersionUID = 2L;
	
	private String name;
	
	private int age;
	
	private Date date;
	
	private String message;
	
	public UserMessage() {
		
	}
	
	public UserMessage(String name, int age, String message) {
		this.name = name;
		this.age = age;
		this.date = new Date();
		this.message = message;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return String.format("[%s] %s (%d years old) said '%s'", format.format(this.date), this.name, this.age, this.message);
	}
}
