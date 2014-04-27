package edu.iastate.cs362.RentalCenter;

import java.util.List;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Customer;
/**
 * Interface for RentalCenter.
 * @author Cameron Johnston
 * @author Bryan Passini
 *
 */
public interface RentalCenterInterface {
	
	/** 
	 * Constant used to signal that the name variable is the field to be updated.
	 */
	static final int UPDATE_NAME = 0; 
	
	/** 
	 * Constants used to determine which field to search equipment by.
	 */
	static final int SEARCH_BY_ID = 1;
	static final int SEARCH_BY_TYPE = 2;
	static final int SEARCH_BY_COST = 3;
	static final int SEARCH_BY_STATUS = 4;
	
	/**
	 * creates and adds a piece of equipment to the RentalCenter
	 * @param equipId - the equipment id
	 * @param equipType - the equipment type
	 * @param cost - the rental cost of the equipment
	 * @param description - a description of the equipment
	 * @param checkedIn - whether the equipment is checked in or not
	 * @return - true if Equipment was created and added successfully, false otherwise
	 */
	boolean addEquipment(String equipId, String equipType, double cost, String description, boolean checkedIn);
	
	/**
	 * Creates an EqupmentInvoice for a specific piece of equipment
	 * @param invoiceId - the invoice id
	 * @param equipId - corresponding equipment id
	 * @param msg - a description of the invoice and what is wrong with the equipment
	 * @return true if EquipmentInvoice was created and added successfully, false otherwise
	 */
	boolean createEquipInvoice(String invoiceId, String equipId, String msg);
	
	/**
	 * Creates a RentalReservation for a specific piece of equipment
	 * @param rentalId - the reservation id
	 * @param equipId - corresponding equipment id
	 * @param customer - the customer for the reservation
	 * @param start - start time for the reservation
	 * @param end - end time for the reservation
	 * @return true if RentalReservation was created and added successfully, false otherwise
	 */
	boolean createRentalReservation(String rentalId, String equipId, Customer customer, DateTime start, DateTime end);
	
	/**
	 * Updates a certain field of the equipment invoice object with the given invoiceId.
	 * @param invoiceId the id of the invoice to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateEquipmentInvoice(String invoiceId, int flag, Object newInfo);
	
	/**
	 * Updates a certain field of the rental reservation object with the given reservation id.
	 * @param reservationId the id of the reservation to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateRentalReservation(String reservationId, int flag, Object newInfo);
	
	/**
	 * Updates a certain field of the equipment with the given equipId. 
	 * @param eid - the equipment id
	 * @param flag - flag used to identify the correct field to be updated
	 * @param u - the object to update to
	 * @return true if update was successful, false otherwise.
	 */
	boolean updateEquipment(String eid, int flag, Object u);
	
	/**
	 * Updates a certain field of a rental center
	 * @param flag - the field we wish to update
	 * @param u - the updated object
	 * @return true if update was successful, false otherwise
	 */
	boolean updateRentalCenter(int flag, Object u);
	
	/**
	 * Checks out a piece of equipment and matches it to a reservation
	 * @param eid - the equipment id we wish to check out
	 * @param rentalId - the rental reservation we wish to correspond this piece with
	 * @return true if checked out successfully, false otherwise
	 */
	boolean checkOutEquipment(String eid, String rentalId);
	
	/**
	 * Checks in a piece of equipment and removes it from the correct reservation
	 * @param eid - the equipment id we wish to check back in
	 * @param rentalId - the rental reservation we need to remove the equipment from
	 * @return true if checked in successfully, false otherwise
	 */
	boolean checkInEquipment(String eid, String rentalId);
	
	/**
	 * Searches equipment of the rental center
	 * @param s - the object to search equipment
	 * @param flag - the field we wish to search equipment by
	 */
	List<Equipment> searchEquipment(Object s, int flag);

}
