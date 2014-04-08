package edu.iastate.cs362.ManagementSystem;

/**
 * An interface used to define what methods need to be in the ManagementSystemController class.
 * 
 * @author Bryan Passini
 *
 */
public interface ManagementSystemControllerInterface {
	/**
	 * Creates a new budget given a budget id.
	 * @param budgetId The id of the new budget object.
	 * @return true if the budget was created successfully, false otherwise.
	 */
	boolean createBudget(String budgetId);
	/**
	 * Creates a new payroll object given an id, a start date and an end date.
	 * @param payrollId The id of the new payroll object.
	 * @param startDate The start date of the new payroll object.
	 * @param endDate The end date of the new payroll object.
	 * @return
	 */
	boolean createPayroll(String payrollId, String startDate, String endDate);
	/**
	 * Creates a new employee.
	 * @param name the name of the employee.
	 * @param type the type of the employee.
	 * @param empID the id of the employee.
	 * @param payRate the hourly pay rate of the employee.
	 * @return true if the employee was created successfully, false otherwise.
	 */
	boolean createEmployee(String fname, String lname, String type, String empID, double payRate);
}
