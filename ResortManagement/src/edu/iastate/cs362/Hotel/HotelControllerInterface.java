package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

/**
 * An interface to define what needs to be implemented in the HotelController class
 * 
 * @author Mike Pruszinske
 *
 */
public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	boolean createRoomReservation(String rrid, String hid, String start, String end, Customer cust, Attribute attr);
	
	
	/**
	 * Updates a certain field of the room reservation object with the given reservation id.  This room reservation to be
	 * updated is held in the hotel with the given hotel id.
	 * @param hId the id of the hotel that contains the room reservation to be updated.
	 * @param reservationId the id of the reservation to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRoomReservation(String hId, String reservationId, int flag, Object newInfo);
}
