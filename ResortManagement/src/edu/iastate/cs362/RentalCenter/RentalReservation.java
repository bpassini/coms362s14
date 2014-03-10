package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

public class RentalReservation implements RentalReservationInterface {

	private String eId;
	private String cname;
	/* TODO will pick "Date" type later */
	private DateTime start;
	private DateTime end;
	
	public RentalReservation(String eId, String cname, DateTime start, DateTime end) {
		this.eId = eId;
		this.cname = cname;
		this.start = start;
		this.end = end;
	}
	
	//TODO getter and setter methods
}
