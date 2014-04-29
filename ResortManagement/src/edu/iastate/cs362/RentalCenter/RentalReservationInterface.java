package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Customer;

/**
 * Interface for RentalReservation.
 * 
 * @author Cameron Johnston
 * @author Bryan Passini
 *
 */
public interface RentalReservationInterface {
	/**
	 * Constant used to signal that the equipment id variable is the field to be updated.
	 */
	static final int UPDATE_EQUIPMENT_ID = 0;
	/**
	 * Constant used to signal that the customer variable is the field to be updated.
	 */
	static final int UPDATE_CUSTOMER = 1;
	/**
	 * Constant used to signal that the start date variable is the field to be updated.
	 */
	static final int UPDATE_START = 2;
	/**
	 * Constant used to signal that the end date variable is the field to be updated.
	 */
	static final int UPDATE_END = 3;
	
	/**
	 * Updates a certain field of this rental reservation object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRentalReservaion(int flag, Object newInfo);
}
