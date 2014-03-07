package edu.iastate.cs362.RentalCenter;

public class RentalReservation implements RentalReservationInterface {

	private String eid;
	private String cname;
	/* TODO will pick "Date" type later */
	private Date start;
	private Date end;
	
	public RentalReservation(String eid, String cname, Date start, Date end) {
		this.eid = eid;
		this.cname = cname;
		this.start = start;
		this.end = end;
	}
	
	//TODO getter and setter methods
}
