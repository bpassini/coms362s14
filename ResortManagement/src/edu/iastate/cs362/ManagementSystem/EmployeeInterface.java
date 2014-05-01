package edu.iastate.cs362.ManagementSystem;

/**
 * Represents an employee that works at the resort.
 * 
 * @author Bryan Passini
 *
 */
public interface EmployeeInterface {
	/**
	 * Constant used to signal that the start date variable is the field to be updated.
	 */
	static final int UPDATE_FIRST_NAME = 0;
	/**
	 * Constant used to signal that the end date variable is the field to be updated.
	 */
	static final int UPDATE_LAST_NAME = 1;
	/**
	 * Constant used to signal that the start date variable is the field to be updated.
	 */
	static final int UPDATE_TYPE = 2;
	/**
	 * Constant used to signal that the end date variable is the field to be updated.
	 */
	static final int UPDATE_PAYRATE = 3;

	/**
	 * Updates a certain field of this employee object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updateEmployee(int flag, Object newInfo);
}
