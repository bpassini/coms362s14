package edu.iastate.cs362.Hotel;

import org.joda.time.*;

public class RoomReservation implements RoomReservationInterface {
	
	/**
	 * Reservation start date
	 */
	DateTime start;
	
	/**
	 * Reservation end date
	 */
	DateTime end;
	
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
	 * @param start - start date
	 * @param end - end date
	 * @param cust - customer object
	 * @param attr - attribute object with desired room attributes
	 */
	public RoomReservation(DateTime start, DateTime end, Customer cust, Attribute attr) {
		
		this.start = start;
		this.end = end;
		this.cust = cust;
		this.attr = attr;
	}

}
