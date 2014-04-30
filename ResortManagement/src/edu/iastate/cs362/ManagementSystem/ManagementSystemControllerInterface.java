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
	
	/**
	 * Updates a certain field of the payroll object with the given payrollId.
	 * @param payrollId the id of the payroll to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updatePayroll(String payrollId, int flag, Object newInfo);
	
	/**
	 * Updates a certain field of the employee info object (represents a payroll row) with the given employeeId.  
	 * This employee info object to be updated is held in the payroll with the given payroll id.
	 * @param payrollId the id of the payroll that contains the employee info to be updated.
	 * @param employeeId the id of the employee info object to be updated.
	 * @param flag the flag used to identify what field is being updated.
	 * @param newInfo the updated information.
	 * @return true if the update was successful, false otherwise.
	 */
	boolean updatePayrollRow(String payrollId, String employeeId, int flag, Object newInfo);
	
	/**
	 * Add a revenue to the budget with the given budgetId.
	 * @param budgetId the budgetId of the budget to add the revenue to.
	 * @param revenueName the name of the revenue being added to the budget.
	 * @param revenueAmount the amount of the revenue being added to the budget.
	 * @return true if the addition occurred successfully, false otherwise.
	 */
	boolean addRevenueToBudget(String budgetId, String revenueName, double revenueAmount);
	
	/**
	 * Add a expense to the budget with the given budgetId.
	 * @param budgetId the budgetId of the budget to add the expense to.
	 * @param expenseName the name of the expense being added to the budget.
	 * @param expenseAmount the amount of the expense being added to the budget.
	 * @return true if the addition occurred successfully, false otherwise.
	 */
	boolean addExpenseToBudget(String budgetId, String expenseName, double expenseAmount);
	
	/**
	 * Adds an employee info object to the payroll list.
	 * @param payrollId the payrollId of the payroll that this employee info is going to be added to.
	 * @param empName the name of the employee.
	 * @param empId the id of the employee.
	 * @param payRate the pay rate of the employee.
	 * @param regularHours the number of regular hours the employee has worked.
	 * @param overtimeHours the number of overtime hours this employee has worked.
	 */
	boolean addPayrollRow(String payrollId, String empName, String empId, double payRate, double regularHours, double overtimeHours);
}
