package edu.iastate.cs362.ManagementSystem;

/**
 * Represents an employee that works at the resort.
 * 
 * @author Bryan Passini
 *
 */
public class Employee implements EmployeeInterface {
	/**
	 * The name of this employee.
	 */
	private String name;
	/**
	 * The employee type of this employee.
	 */
	private String type;
	/**
	 * The id of this employee.
	 */
	private String empId;
	/**
	 * The hourly pay rate of this employee.
	 */
	private double payRate;
	
	/**
	 * Creates an employee object given a name, type, empId and an hourly pay rate.
	 * @param name the name of the employee.
	 * @param type the type of the employee.
	 * @param empId the id of the employee.
	 * @param payRate the hourly pay rate of the employee.
	 */
	public Employee(String name, String type, String empId, double payRate) {
		this.name = name;
		this.type = type;
		this.empId = empId;
		this.payRate = payRate;
	}
}
