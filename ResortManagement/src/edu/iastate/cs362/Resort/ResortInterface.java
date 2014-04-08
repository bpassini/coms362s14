package edu.iastate.cs362.Resort;

import java.util.ArrayList;

import org.joda.time.*;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;

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
	 * @return true if the Equipment was added successfully, false otherwise
	 */
	boolean addEquipment(String rId, String equipId, String equipType, double cost, String description);
	
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
}
