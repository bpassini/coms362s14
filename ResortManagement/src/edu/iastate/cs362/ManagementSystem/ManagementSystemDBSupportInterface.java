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
}
