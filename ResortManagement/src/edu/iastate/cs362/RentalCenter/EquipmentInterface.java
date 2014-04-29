package edu.iastate.cs362.RentalCenter;

/**
 * Interface for Equipment class
 * 
 * @author Cameron Johnston
 *
 */
public interface EquipmentInterface {
	
	/**
	 * Constant used to signal that the equipment type variable is the field to be updated.
	 */
	static final int UPDATE_TYPE = 0;
	/**
	 * Constant used to signal that the equipment cost variable is the field to be updated.
	 */
	static final int UPDATE_COST = 1;
	
	/**
	 * Constant used to signal that the equipment description variable should be updated.
	 */
	static final int UPDATE_DESCRIPTION = 2;
	
	
	/**
	 * This method updates the Equipment.
	 * @param flag int telling Equipment what variable to update
	 * @param u - the updated object
	 * @return true if successful, false otherwise
	 */
	boolean updateEquipment(int flag, Object u);
	
	/**
	 * checks out the piece of Equipment
	 * @return true if it was successfully checkedOut, false otherwise
	 */
	boolean checkOutEquipment();
	
	/**
	 * checks in the piece of Equipment
	 * @return true if it was successfully checkedIn, false otherwise
	 */
	boolean checkInEquipment();
}