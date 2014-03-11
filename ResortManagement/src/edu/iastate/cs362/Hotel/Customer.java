package edu.iastate.cs362.Hotel;

import java.util.List;

public class Customer {
	
	/**
	 * Customer ID
	 */
	int cmid;
	
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
	
}
