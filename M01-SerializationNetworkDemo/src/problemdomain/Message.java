package problemdomain;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author Nick Hamnett
 * @version 2019-07-15
 *
 */
public class Message implements Serializable {
	private Date date;
	
	private String message;
	
	public Message() {
		
	}
	
	public Message(String message) {
		this.date = new Date();
		this.message = message;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return String.format("[%s] %s", format.format(this.date), this.message);
	}
}
