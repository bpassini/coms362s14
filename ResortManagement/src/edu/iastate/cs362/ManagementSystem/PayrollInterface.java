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
	
	/**
	 * Updates a certain field of the employee info object with the given employee id.
	 * @param employeeId the id of the employee info object to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updatePayrollRow(String employeeId, int flag, Object newInfo);
	
	/**
	 * Adds an employee info object to the payroll list.
	 * @param empName the name of the employee.
	 * @param empId the id of the employee.
	 * @param payRate the pay rate of the employee.
	 * @param regularHours the number of regular hours the employee has worked.
	 * @param overtimeHours the number of overtime hours this employee has worked.
	 */
	boolean addPayrollRow(String empName, String empId, double payRate, double regularHours, double overtimeHours);
}
