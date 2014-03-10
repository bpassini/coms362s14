package edu.iastate.cs362.ManagementSystem;

/**
 * An interface used to define what methods need to be in the ManagementSystemController class.
 * 
 * @author Bryan Passini
 *
 */
public interface ManagementSystemControllerInterface {
	/**
	 * Creates a new budget.
	 * @return true if the budget was created successfully, false otherwise.
	 */
	boolean createBudget();
	/**
	 * Creates a new payroll object.
	 * @return true if the payroll was create successfully, false otherwise.
	 */
	boolean createPayroll();
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
