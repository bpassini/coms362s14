package edu.iastate.cs362.ManagementSystem;

/**
 * An interface used to define what methods need to be implemented in the payroll class.
 * 
 * @author Bryan Passini
 *
 */
public interface PayrollInterface {
	/**
	 * Constant used to signal that the start date variable is the field to be updated.
	 */
	static final int UPDATE_START_DATE = 0;
	/**
	 * Constant used to signal that the end date variable is the field to be updated.
	 */
	static final int UPDATE_END_DATE = 1;
	
	/**
	 * Updates a certain field of this payroll object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updatePayroll(int flag, Object newInfo);
}
