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
	 * @param customer - Customer for this reservation.
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
	
	/**
	 * Get the RentalReservation id
	 * @return the id of the reservation
	 */
	public String getRentalId() {
		return rentalId;
	}

	/**
	 * Get the Equipment id correlating to this reservation
	 * @return the id of the piece equipment
	 */
	public String getEquipId() {
		return equipId;
	}

	/**
	 * Get the Customer from this RentalReservation
	 * @return the customer of the reservation
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * Get the start DateTime for this RentalReservation
	 * @return start time of the reservation
	 */
	public DateTime getStart() {
		return start;
	}

	/**
	 * Get the end DateTime for this RentalReservation
	 * @return end time of the reservation
	 */
	public DateTime getEnd() {
		return end;
	}
	
}
