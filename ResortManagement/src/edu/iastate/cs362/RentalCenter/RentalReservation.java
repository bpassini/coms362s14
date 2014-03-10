package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

public class RentalReservation implements RentalReservationInterface {

	private String eid;
	private String cname;
	/* TODO will pick "Date" type later */
	private DateTime start;
	private DateTime end;
	
	public RentalReservation(String eid, String cname, DateTime start, DateTime end) {
		this.eid = eid;
		this.cname = cname;
		this.start = start;
		this.end = end;
	}
	
	//TODO getter and setter methods
}
