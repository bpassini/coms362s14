package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.*;

/**
 * An interface to define what needs to be implemented in the Hotel class
 * 
 * @author Mike Pruszinske
 * @author Bryan Passini
 *
 */
public interface HotelInterface {
	boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	
	/**
	 * Updates a certain field of the room reservation object with the given reservation id.
	 * @param reservationId the id of the reservation to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRoomReservation(String reservationId, int flag, Object newInfo);
}
