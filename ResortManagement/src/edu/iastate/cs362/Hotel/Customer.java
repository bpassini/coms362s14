package edu.iastate.cs362.Hotel;

/**
 * Represents a hotel customer
 * 
 * @author Mike Pruszinske
 *
 */
public class Customer {
	
	/**
	 * Customer ID
	 */
	private int cmid;
	
	/**
	 * Customer's first name
	 */
	String firstName;
	
	/**
	 * Customer's last name
	 */
	String lastName;
	
	
	/**
	 * Creates a new customer with the given parameters
	 * 
	 * @param cmid - Customer ID (should this be randomly generated?)
	 * @param firstName - First name of customer
	 * @param lastName - Last name of customer
	 */
	public Customer(int cmid, String firstName, String lastName) {
		
		this.cmid = cmid;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getCmid() {
		return cmid;
	}

	public void setCmid(int cmid) {
		this.cmid = cmid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
