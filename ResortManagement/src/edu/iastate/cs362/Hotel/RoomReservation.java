package edu.iastate.cs362.Hotel;


import java.util.Date;

public class RoomReservation implements RoomReservationInterface {
	
	/**
	 * Name of hotel for reservation
	 */
	String hotel;
	
	/**
	 * Reservation start date
	 */
	Date start;
	
	/**
	 * Reservation end date
	 */
	Date end;
	
	/**
	 * Customer making reservation
	 */
	Customer cust;
	
	/**
	 * Customer's desired room attributes
	 */
	Attribute attr;	

}
