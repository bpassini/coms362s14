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
	
	/** 
	 * Constant used to signify hotel name is the field to be updated
	 */
	static final int UPDATE_NAME = 0;
	
	/**
	 * Adds a room to the current hotel
	 * @param beds - ArrayList of bed types, size = number of beds
	 * @param occup - max room occupancy
	 * @param desc - description of room (view, has kitchen, handicap access, etc.)
	 * @param rmid - room ID given to new room
	 * @return true if room successfully created, false otherwise
	 */
	boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid);
	
	/**
	 * Creates a room invoice
	 * @param hid - Hotel ID of the current hotel that holds specified room
	 * @param rmid - Specified room that invoice is being created for
	 * @param iid - Invoice ID associated with 
	 * @param notes - Notes/description associated with the invoice
	 * @return true if invoice successfully created, false otherwise
	 */
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	
	/**
	 * Creates a room reservation
	 * @param rrid - Room reservation ID associated with this reservation
	 * @param hid - Hotel ID where the room is to be reserved
	 * @param start - Start date of the reservation
	 * @param end - End date of the reservation
	 * @param cust - Customer object who is placing the reservation
	 * @param attr - Attribute object of minimum desired room attributes
	 * @return True if room reservation created successfully, false otherwise
	 */
	boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	
	/**
	 * Updates a certain field of the room reservation object with the given reservation id.
	 * @param reservationId the id of the reservation to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRoomReservation(String reservationId, int flag, Object newInfo);
	
	/**
	 * Updates the current hotel object
	 * @param flag - Flag used to identify what field is being updated
	 * @param u - the updated information
	 * @return True if hotel successfully updated, false otherwise
	 */
	boolean updateHotel(int flag, Object u);
	
	/**
	 * Checks into a hotel room and matches it to a room reservation
	 * @param rid - the room ID of the room being checked into
	 * @param rrid - the room reservation ID corresponding to this room and reservation
	 * @return true if room was checked into successfully, false otherwise
	 */
	boolean checkIntoRoom(int rid, String rrid);
	
	/**
	 * Checks out of hotel room and removes it from corresponding room reservation
	 * @param rid - the room ID of the room being checked out of
	 * @param rrid - the room reservation ID corresponding to this room and reservation
	 * @return true if room was checked out of successfully, false otherwise
	 */
	boolean checkOutOfRoom(int rid, String rrid);
}
