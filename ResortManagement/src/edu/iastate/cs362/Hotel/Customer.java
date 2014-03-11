package edu.iastate.cs362.Hotel;

import java.util.List;

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
	
	public Customer(int cmid, String firstName, String lastName) {
		
		this.cmid = cmid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pastStays = null;
	}

	public int getCmid() {
		return cmid;
	}

	public void setCmid(int cmid) {
		this.cmid = cmid;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the pastStays
	 */
	public List<RoomReservation> getPastStays() {
		return pastStays;
	}

	/**
	 * @param pastStays the pastStays to set
	 */
	public void setPastStays(List<RoomReservation> pastStays) {
		this.pastStays = pastStays;
	}
	
}
