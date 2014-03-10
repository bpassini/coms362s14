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
	
	
	/**
	 * Creates a new room reservation with the given parameters
	 * 
	 * @param hotel - hotel name
	 * @param start - start date
	 * @param end - end date
	 * @param cust - customer object
	 * @param attr - attribute object with desired room attributes
	 */
	public RoomReservation(String hotel, Date start, Date end, Customer cust, Attribute attr) {
		
		this.hotel = hotel;
		this.start = start;
		this.end = end;
		this.cust = cust;
		this.attr = attr;
	}
	
	// TODO get and sets

}
