package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Customer;

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
	private String equipId;
	/**
	 * Customer name for this reservation.
	 */
	// TODO: change to a Customer object instead of  a String
	private Customer customer;
	
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
	 * @param equipId - Id for the corresponding piece of equipment for this reservation.
	 * @param cname - Customer name for this reservation.
	 * @param start - Start time for the reservation.
	 * @param end - End time for the reservation.
	 */
	public RentalReservation(String rentalId, String equipId, Customer customer, DateTime start, DateTime end) {
		this.rentalId = rentalId;
		this.equipId = equipId;
		this.customer = customer;
		this.start = start;
		this.end = end;
	}
	
	public String getRentalId() {
		return rentalId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCname(Customer customer) {
		this.customer = customer;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	
}
