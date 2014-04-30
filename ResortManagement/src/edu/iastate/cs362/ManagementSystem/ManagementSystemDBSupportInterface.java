package edu.iastate.cs362.ManagementSystem;

/**
 * An interface that define what methods need to be in the ManagementSystemDBSupport class.
 * 
 * @author Bryan Passini
 *
 */
public interface ManagementSystemDBSupportInterface {
	/**
	 * Puts a budget object into the database.
	 * @param b the budget object to be put into the database.
	 * @return true if the budget was successfully put into the database, false otherwise.
	 */
	boolean putBudget(Budget b);
	/**
	 * Puts a payroll object into the database.
	 * @param p the payroll object to be put into the database.
	 * @return true if the payroll was successfully put into the database, false otherwise.
	 */
	boolean putPayroll(Payroll p);
	/**
	 * Puts an employee object into the database.
	 * @param e the employee object to be put into the database.
	 * @return true if the employee was successfully put into the database, false otherwise.
	 */
	boolean putEmployee(Employee e);
	
	/**
	 * Gets the payroll object from the database with the given payroll id.
	 * @param payrollId the id of the payroll that needs to be retrieved from the database.
	 * @return the payroll object retrieved from the database.
	 */
	Payroll getPayroll(String payrollId);
	
	/**
	 * Gets the budget object from the database with the given budget id.
	 * @param budgetId the id of the budget that needs to be retrieved from the database.
	 * @return the budget object retrieved from the database.
	 */
	Budget getBudget(String budgetId);
	
	/**
	 * Gets the employee object from the database with the given employee id.
	 * @param employeeId the id of the employee that needs to be retrieved from the database.
	 * @return the employee object retrieved from the database.
	 */
	Employee getEmployee(String employeeId);
}
