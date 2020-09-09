package problemdomain;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author Nick Hamnett
 * @version 2019-07-15
 *
 */
public class MessageExtern implements Externalizable {
	static final long serialVersionUID = 1L;
	
	private Date date;
	
	private String message;
	
	public MessageExtern() {
		
	}
	
	public MessageExtern(String message) {
		this.date = new Date();
		this.message = message;
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
		
		return String.format("[%s] %s", format.format(this.date), this.message);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// Write the unix time from date.
		out.writeLong(this.date.getTime());
		
		// Write the message as UTF.
		out.writeUTF(this.message);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		long unixTime = in.readLong();
		this.date = new Date(unixTime);
		
		String message = in.readUTF();
		this.message = message;
	}
}
