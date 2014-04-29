package edu.iastate.cs362.Hotel;

import org.joda.time.DateTime;

/**
 * An interface to define what needs to be implemented in the RoomReservation class
 * 
 * @author Mike Pruszinske
 * @author Bryan Passini
 *
 */
public interface RoomReservationInterface {
	/**
	 * Constant used to signal that the hotel id variable is the field to be updated.
	 */
	static final int UPDATE_HOTEL_ID = 0;
	/**
	 * Constant used to signal that the start date variable is the field to be updated.
	 */
	static final int UPDATE_START_DATE = 1;
	/**
	 * Constant used to signal that the end date variable is the field to be updated.
	 */
	static final int UPDATE_END_DATE = 2;
	/**
	 * Constant used to signal that the customer variable is the field to be updated.
	 */
	static final int UPDATE_CUSTOMER = 3;
	/**
	 * Constant used to signal that the attribute variable is the field to be updated.
	 */
	static final int UPDATE_ATTRIBUTE = 4;	
	
	/**
	 * Updates a certain field of this room reservation object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRoomReservation(int flag, Object newInfo);
}
