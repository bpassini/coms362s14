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
	 * List of customer's previous stays
	 */
	List<RoomReservation> pastStays;
	
}
