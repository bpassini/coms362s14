package edu.iastate.cs362.ManagementSystem;

/**
 * An interface used to define what methods need to be implemented in the EmployeeInfo class.
 * 
 * @author Bryan Passini
 *
 */
public interface EmployeeInfoInterface {
	/**
	 * Constant used to signal that the regular hours variable is the field to be updated.
	 */
	static final int UPDATE_REGULAR_HOURS = 1;
	/**
	 * Constant used to signal that the overtime hours variable is the field to be updated.
	 */
	static final int UPDATE_OVERTIME_HOURS = 2;
	
	/**
	 * Updates a certain field of this employee info object.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the update information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updatePayrollRow(int flag, Object newInfo);
}
