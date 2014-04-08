package edu.iastate.cs362.RentalCenter;

/**
 * Interface for EquipmentInvoice class
 * 
 * @author Cameron Johnston
 * @author Bryan Passini
 *
 */
public interface EquipmentInvoiceInterface {
	
	/**
	 * Constant used to signal that the message is the field to be updated.
	 */
	public static final int UPDATE_MESSAGE = 0;
	/**
	 * Constant used to signal that the equipment invoice id is the field to be updated.
	 */
	public static final int UPDATE_EQUIPMENT_ID = 1;
	
	/**
	 * Updates a certain field of this equipment invoice object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	public boolean updateEquipmentInvoice(int flag, Object newInfo);
}
