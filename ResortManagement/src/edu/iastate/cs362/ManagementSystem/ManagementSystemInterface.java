package edu.iastate.cs362.ManagementSystem;

import org.joda.time.DateTime;

/**
 * Interface used to define what methods need to be included in the ManamentSystem class.
 * 
 * @author Bryan Passini
 *
 */
public interface ManagementSystemInterface {
	/**
	 * Creates a new Budget object given the id of the budget.
	 * @param budgetId The id of the budget.
	 * @return true if the budget was created successfully, false otherwise.
	 */
	boolean createBudget(String budgetId);
	/**
	 * Creates a new payroll object given the id of the payroll, a start date and an end date.
	 * @param payrollId The id of the payroll.
	 * @param startTime The start date of the payroll.
	 * @param endDate The end date of the payroll.
	 * @return
	 */
	boolean createPayroll(String payrollId, DateTime startTime, DateTime endDate);
	/**
	 * Creates a new employee.
	 * @param name the name of the employee.
	 * @param type the type of the employee.
	 * @param empID the id of the employee.
	 * @param payRate the hourly pay rate of the employee.
	 * @return true if the employee was created successfully, false otherwise.
	 */
	boolean createEmployee(String name, String type, String empID, double payRate);
}
