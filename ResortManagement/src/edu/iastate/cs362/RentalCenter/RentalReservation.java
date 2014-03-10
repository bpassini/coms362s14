package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

/**
 * Class for a reservation of a piece of rental equipment. 
 * 
 * @author Cameron Johnston
 *
 */
public class RentalReservation implements RentalReservationInterface {

	/**
	 * Id for this rental reservation.
	 */
	private String rentalId;
	/**
	 * Id for the corresponding piece of equipment for this reservation.
	 */
	private String eId;
	/**
	 * Customer name for this reservation.
	 */
	private String cname;
	
	/**
	 * Start time for the reservation.
	 */
	private DateTime start;
	
	/**
	 * End time for the reservation.
	 */
	private DateTime end;
	
	/**
	 * Creates a new RentalReservation.
	 * @param rentalId - Id for this rental reservation.
	 * @param eId - Id for the corresponding piece of equipment for this reservation.
	 * @param cname - Customer name for this reservation.
	 * @param start - Start time for the reservation.
	 * @param end - End time for the reservation.
	 */
	public RentalReservation(String rentalId, String eId, String cname, DateTime start, DateTime end) {
		this.eId = eId;
		this.cname = cname;
		this.start = start;
		this.end = end;
	}
	
	//TODO getter and setter methods
}
