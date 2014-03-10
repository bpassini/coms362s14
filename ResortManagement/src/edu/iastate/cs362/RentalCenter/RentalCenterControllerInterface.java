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
	 * @param rid - The id for this Rental Center.
	 * @param name - The name of this Rental Center.
	 * @return a boolean value telling success/failure of creating a new RentalCenter
	 */
	boolean createRentalCenter(String rid, String name);
	
	/**
	 * Creates a new piece of Equipment and adds it to a specific RentalCenter.
	 * @param rid - The id of the specific RentalCenter this equipment will be stored in.
	 * @param eid - The id of the new piece of equipment
	 * @param equipType - The type of this equipment.
	 * @param cost - The rental cost of this piece of equipment.
	 * @param description - The description of this piece of equipment.
	 * @return a boolean value telling success/failure of adding a new piece of equipment
	 */
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	
	/**
	 * Creates a new EquipmentInvoice for a specific piece of Equipment.
	 * @param rid - The id of the specific RentalCenter this invoice is for.
	 * @param id -  The id for this invoice.
	 * @param eId - The id for the corresponding equipment of this invoice. 
	 * @param msg - The message of the invoice. 
	 * @return a boolean value telling success/failure of creating a new invoice.
	 */
	boolean createEquipInvoice(String rid, String iId, String eid, String msg);
	
	/**
	 * Creates a RentalReservation for a specifice Equipment in one of the RentalCenters.
	 * @param rid - The id of the specific RentalCenter this invoice is for.
	 * @param rentalId - the id for this specific rentalReservation
	 * @param eid - The id for the corresponding equipment of this invoice. 
	 * @param cname - The customer name for this reservation.
	 * @param startDate - The start date for this reservation.
	 * @param endDate - The end date for this reservation.
	 * @return a boolean value telling success/failure of creating a new reservation.
	 */
	boolean createRentalReservation(String rid, String rentalId, String eid, String cname, String startDate, String endDate);
}
