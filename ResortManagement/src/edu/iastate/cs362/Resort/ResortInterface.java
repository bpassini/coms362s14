package edu.iastate.cs362.Resort;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Hotel.Room;
import edu.iastate.cs362.RentalCenter.Equipment;

/**
 * Interface for Resort.
 * 
 * @author Cameron Johnston
 * @author Mike Pruszinske
 * @author Bryan Passini
 *
 */
public interface ResortInterface {
	/**
	 * Creates a new RentalCenter
	 * @param rId - the RentalCenter id
	 * @param name - the name of the RentalCenter
	 * @return true if RentalCenter was created successfully, false otherwise 
	 */
	boolean createRentalCenter(String rId, String name);

	/**
	 * Creates a new Hotel
	 * 
	 * @param hid - the Hotel ID
	 * @param name - the Hotel name
	 * @return true if Hotel was created successfully, false otherwise
	 */
	boolean createHotel(String hid, String name);

	/**
	 * Creates and adds a Room to a specific Hotel
	 * 
	 * @param hid - the Hotel ID
	 * @param beds - the number and type of beds in the room
	 * @param occup - max occupancy of room
	 * @param desc - additional description of the room
	 * @param rmid - the Room ID
	 * @return - true if Room was successfully created and added, false otherwise
	 */
	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);

	/**
	 * Create and add a piece of Equipment to a specific RentalCenter.
	 * @param rId - the RentalCenter id
	 * @param equipId - the Equipment id
	 * @param equipType - the type of equipment
	 * @param cost - the rental cost of the equipment
	 * @param description - a description of the equipment
	 * @param checkedIn - true if checked in, false otherwise
	 * @return true if the Equipment was added successfully, false otherwise
	 */
	boolean addEquipment(String rId, String equipId, String equipType, double cost, String description, boolean checkedIn);
	
	/**
	 * Creates and adds a RoomInvoice for a room in a specific Hotel
	 * 
	 * @param hid - the Hotel ID
	 * @param rmid - the room ID
	 * @param iid - the invoice ID
	 * @param notes - Notes and/or description of the issue
	 * @return - true if RoomInvoice was added successfully, false otherwise
	 */
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	
	/**
	 * Creates and adds a RoomReservation for a specific Hotel
	 * 
	 * @param rrid - the Room Reservation ID
	 * @param hid - the Hotel ID
	 * @param start - the reservation start date
	 * @param end - the reservation end date
	 * @param cust - the customer making reservation
	 * @param attr - the desired room attributes
	 * @return - true if RoomReservation was added successfully, false otherwise
	 */
	boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	
	/**
	 * Creates an EquipmentInvoice for a piece of Equipment in a RentalCenter
	 * @param rId - the RentalCenter id
	 * @param invoiceId - the EquipmentInvoice id
	 * @param equipId - the Equipment id
	 * @param msg - a description of the invoice and what is wrong with the Equipment
	 * @return true if the EquipmentInvoice is created successfully, false otherwise
	 */
	boolean createEquipInvoice(String rId, String invoiceId,  String equipId, String msg);
	
	/**
	 * Creates a RentalReservation for a piece of equipment in a specific RentalCenter.
	 * @param rId - the RentalCenter id
	 * @param rentalId - the RentalReservation id
	 * @param equipId - the corresponding Equipment id
	 * @param customer - the customer
	 * @param start - the start time of the reservation
	 * @param end - the end time of the reservation
	 * @return true if RentalReservation was created successfully, false otherwise
	 */
	boolean createRentalReservation(String rId, String rentalId, String equipId, Customer customer, DateTime start, DateTime end);
	
	/**
	 * Updates a certain field of the equipment invoice object with the given invoiceId.  This equipment invoice to be updated
	 * is held in the rental center with the given rental center id.
	 * @param rId the id of the rental center that contains the equipment invoice to be updated.
	 * @param invoiceId the id of the invoice to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateEquipmentInvoice(String rId, String invoiceId, int flag, Object newInfo);
	
	/**
	 * Updates a certain field of the rental reservation object with the given reservation id.  This rental reservation to be
	 * updated is held in the rental center with the given rental center id.
	 * @param rId the id of the rental center that contains the rental reservation to be updated.
	 * @param reservationId the id of the reservation to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRentalReservation(String rId, String reservationId, int flag, Object newInfo);
	/**
	 * Updates a certain field of the equipment with the given equipId. 
	 * @param rid - the id of the rental center the equipment is held in
	 * @param eid - the equipment id
	 * @param flag - flag used to identify the correct field to be updated
	 * @param u - the object to update to
	 * @return true if update was successful, false otherwise.
	 */
	
	boolean updateEquipment(String rid, String eid, int flag, Object u);
	
	/**
	 * Updates a certain field of a rental center with the matching rid
	 * @param rid - the rental center id
	 * @param flag - the field we wish to update
	 * @param u - the updated object
	 * @return true if update was successful, false otherwise
	 */
	boolean updateRentalCenter(String rid, int flag, Object u);
	
	/**
	 * Checks out a piece of equipment and matches it to a reservation
	 * @param rid - the rental center id
	 * @param eid - the equipment id we wish to check out
	 * @param rentalId - the rental reservation we wish to correspond this piece with
	 * @return true if checked out successfully, false otherwise
	 */
	boolean checkOutEquipment(String rid, String eid, String rentalId);
	
	/**
	 * Checks in a piece of equipment and removes it from the correct reservation
	 * @param rid - the rental center id
	 * @param eid - the equipment id we wish to check back in
	 * @param rentalId - the rental reservation we need to remove the equipment from
	 * @return true if checked in successfully, false otherwise
	 */
	boolean checkInEquipment(String rid, String eid, String rentalId);
	
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
	 * Updates a certain field of the hotel with the matching hotel ID
	 * @param hid - the hotel ID
	 * @param flag - the flag used to identify what field is being updated
	 * @param newInfo - the updated information
	 * @return true if the update was successful, false otherwise.
	 */	
	boolean updateHotel(String hid, int flag, Object u);
	
	/**
	 * Checks into a hotel room and matches it to a room reservation
	 * @param hid - the hotel ID of the hotel that holds the room
	 * @param rid - the room ID of the room being checked into
	 * @param rrid - the room reservation ID corresponding to this room and reservation
	 * @return true if room was checked into successfully, false otherwise
	 */
	boolean checkIntoRoom(String hid, int rid, String rrid);
	
	/**
	 * Checks out of hotel room and removes it from corresponding room reservation
	 * @param hid - the hotel ID of the hotel that holds the room
	 * @param rid - the room ID of the room being checked out of
	 * @param rrid - the room reservation ID corresponding to this room and reservation
	 * @return true if room was checked out of successfully, false otherwise
	 */
	boolean checkOutOfRoom(String hid, int rid, String rrid);
	
	/**
	 * Searches equipment of a specific rental center
	 * @param rid - the rental center id
	 * @param s - the object to search equipment
	 * @param flag - the field we wish to search equipment by
	 */
	List<Equipment> searchEquipment(String rid, Object s, int flag);
	
	/**
	 * Updates the room invoice of a specific hotel room
	 * @param hid - hotel id
	 * @param iid - invoice id
	 * @param flag - the field we wish to update
	 * @param u - the updated information object
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
	List<Room> checkRoomAvailability(String hid, DateTime start, DateTime end);
	
	/**
	 * Searches rooms of a specific hotel
	 * @param hid - hotel id
	 * @param flag - the field we wish to search rooms by
	 * @param u - the object to search rooms for
	 * @return a list of hotel rooms that match the given search parameters
	 */
	List<Room> searchRooms(String hid, Object u, int flag);
	
}
