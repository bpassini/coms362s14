package edu.iastate.cs362.ManagementSystem;

import org.joda.time.DateTime;

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
	 * Puts a work schedule into the database
	 * @param date - the date the employee is scheduled to work
	 * @param employeeId - the id of the specific employee
	 * @param start - the start time of the shift (0-23.99)
	 * @param hours - the amount of hours an employee will work
	 * @return true if it was successfully stored, false otherwise
	 */
	boolean putWorkSchedule(WorkSchedule w);
}
