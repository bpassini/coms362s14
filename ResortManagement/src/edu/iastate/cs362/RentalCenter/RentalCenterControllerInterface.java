package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;
/**
 * Interface for our RentalCenterController.
 * 
 * @author Cameron Johnston
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
	 * @param cname - The customer name for this reservation.
	 * @param startDate - The start date for this reservation.
	 * @param endDate - The end date for this reservation.
	 * @return true if RentalReservation was created and added successfully, false otherwise
	 */
	boolean createRentalReservation(String rId, String rentalId, String equipId, String cname, String startDate, String endDate);
}
