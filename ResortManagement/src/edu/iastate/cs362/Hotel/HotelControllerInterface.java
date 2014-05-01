package edu.iastate.cs362.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * An interface to define what needs to be implemented in the HotelController class
 * 
 * @author Mike Pruszinske
 *
 */
public interface HotelControllerInterface {
	
	/**
	 * Creates a new hotel
	 * @param hid - Hotel ID
	 * @param name - Name of hotel
	 * @return true if hotel successfully created, false otherwise
	 */
	boolean createHotel(String hid, String name);
	
	/**
	 * Adds a new room to the specified hotel
	 * @param hid - Hotel ID where room will be added
	 * @param beds - ArrayList of types of beds, size = num of beds
	 * @param occup - Max occupancy of rooms
	 * @param desc - Room description
	 * @param rmid - Room ID (room number)
	 * @return True if room successfully added, false otherwise
	 */
	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);
	
	/**
	 * Creates a new room invoice
	 * @param hid - Hotel ID where room is located
	 * @param rmid - Room ID of room invoice is associated with
	 * @param iid - Invoice ID associated with this invoice
	 * @param notes - Notes associated with invoice
	 * @return True if invoice successfully created, false otherwise
	 */
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	
	/**
	 * Creates a new room reservation
	 * @param rrid - Room Reservation ID associated with this reservation
	 * @param hid - Hotel ID where room is located
	 * @param start - Start date of reservation
	 * @param end - End date of reservation
	 * @param cust - Customer who placed reservation
	 * @param rmid - Room ID
	 * @return True if reservation successfully created, false otherwise
	 */
	boolean createRoomReservation(String rrid, String hid, String start, String end, Customer cust, int rmid);
	
	
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
	
	/**
	 * Updates the hotel
	 * @param hid - The hotel ID of the hotel to be updated
	 * @param flag - Flag to determine which field is being updated
	 * @param u - The updated object (usually String)
	 * @return True if hotel successfully updated, false otherwise
	 */
	boolean updateHotel(String hid, int flag, Object u);
	
	/**
	 * Check into hotel room and associate room with RoomReservation
	 * @param hid - Hotel ID of hotel that holds room
	 * @param rid - Room ID of room being checked into
	 * @param rrid - RoomReservation ID of reservation associated with this check in
	 * @return True if successfully checked into room, false otherwise
	 */
	boolean checkIntoRoom(String hid, int rid, String rrid);
	
	/**
	 * Checks out of hotel room and removes it from corresponding room reservation
	 * @param hid - Hotel ID of hotel that holds room
	 * @param rid - the room ID of the room being checked out of
	 * @param rrid - the room reservation ID corresponding to this room and reservation
	 * @return true if room was checked out of successfully, false otherwise
	 */
	boolean checkOutOfRoom(String hid, int rid, String rrid);

	/**
	 * Updates the room invoice of a specific hotel room
	 * @param hid - hotel id
	 * @param iid - invoice id
	 * @param u - the updated information object
	 * @param flag - the field we wish to update
	 * @return true if room invoice was successfully updated, false otherwise
	 */
	boolean updateRoomInvoice(String hid, String iid, Object u, int flag);	

	/**
	 * Checks which rooms are available during a given date range
	 * @param hid - hotel id
	 * @param start - start date
	 * @param end - end date
	 * @return a list of rooms available in the given hotel during the given date range
	 */
	List<Room> checkRoomAvailability(String hid, String start, String end);
	
	/**
	 * Searches rooms of a specific hotel
	 * @param hid - hotel id
	 * @param u - the object to search rooms for
	 * @param flag - the field we wish to search rooms by
	 * @return a list of hotel rooms that match the given search parameters
	 */
	List<Room> searchRooms(String hid, Object u, int flag);

}
