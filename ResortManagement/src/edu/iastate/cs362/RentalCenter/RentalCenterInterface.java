package edu.iastate.cs362.RentalCenter;

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
	 * creates and adds a piece of equipment to the RentalCenter
	 * @param equipId - the equipment id
	 * @param equipType - the equipment type
	 * @param cost - the rental cost of the equipment
	 * @param description - a description of the equipment
	 * @return - true if Equipment was created and added successfully, false otherwise
	 */
	boolean addEquipment(String equipId, String equipType, double cost, String description);
	
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
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	public boolean updateEquipmentInvoice(String invoiceId, int flag, Object newInfo);
}
