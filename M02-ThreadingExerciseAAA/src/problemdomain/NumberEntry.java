/**
 * 
 */
package problemdomain;

/**
 * @author nhamnett
 *
 */
public class NumberEntry {
	private int value;
	
	private String createdBy;
	
	public NumberEntry() {
		
	}
	
	public NumberEntry(int value, String createdBy) {
		this.setValue(value);
		this.setCreatedBy(createdBy);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String toString() {
		return this.createdBy + " " + this.value;
	}
}
