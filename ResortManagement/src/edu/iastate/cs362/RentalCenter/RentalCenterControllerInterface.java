package edu.iastate.cs362.RentalCenter;

import edu.iastate.cs362.Hotel.Customer;
/**
 * Interface for our RentalCenterController.
 * 
 * @author Cameron Johnston
 * @author Bryan Passini
 *
 */

public interface RentalCenterControllerInterface {
	
	/**
	 * Creates a new RentalCenter.
	 * @param rId - The id for this Rental Center.
	 * @param name - The name of this Rental Center.
	 * @return true if RentalCenter was created successfully, false otherwise
	 */
	boolean createRentalCenter(String rId, String name);
	
	/**
	 * Creates a new piece of Equipment and adds it to a specific RentalCenter.
	 * @param rId - The id of the specific RentalCenter this equipment will be stored in.
	 * @param equipId - The id of the new piece of equipment
	 * @param equipType - The type of this equipment.
	 * @param cost - The rental cost of this piece of equipment.
	 * @param description - The description of this piece of equipment.
	 * @return true if Equipment was created and added successfully, false otherwise
	 */
	boolean addEquipment(String rId, String equipId, String equipType, double cost, String description);
	
	/**
	 * Creates a new EquipmentInvoice for a specific piece of Equipment.
	 * @param rId - The id of the specific RentalCenter this invoice is for.
	 * @param invoiceId -  The id for this invoice.
	 * @param equipId - The id for the corresponding equipment of this invoice. 
	 * @param msg - The message of the invoice. 
	 * @return true if EquipmentInvoice was created and added successfully, false otherwise
	 */
	boolean createEquipInvoice(String rId, String invoiceId, String equipId, String msg);
	
	/**
	 * Creates a RentalReservation for a specific piece of Equipment in one of the RentalCenters.
	 * @param rId - The id of the specific RentalCenter this invoice is for.
	 * @param rentalId - the id for this specific rentalReservation
	 * @param equipId - The id for the corresponding equipment of this invoice. 
	 * @param customer - The customer for this reservation.
	 * @param startDate - The start date for this reservation.
	 * @param endDate - The end date for this reservation.
	 * @return true if RentalReservation was created and added successfully, false otherwise
	 */
	boolean createRentalReservation(String rId, String rentalId, String equipId, Customer customer, String startDate, String endDate);
	
	/**
	 * Updates a certain field of the equipment invoice object with the given invoiceId.  This equipment invoice is held
	 * in the rental center with the given rental center id.
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
	boolean updateRentalReservation(String rcId, String reservationId, int flag, Object newInfo);
	
	boolean updateEquipment(String rid, String eid, int flag, Object u);
	boolean updateRentalCenter(String rid, int flag, Object u);
	boolean checkOutEquipment(String rid, String eid, String rentalId);
	boolean checkInEquipment(String rid, String eid, String rentalId);

}
