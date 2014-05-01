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
	private String fName;
	/**
	 * The name of this employee.
	 */
	private String lName;
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
	public Employee(String fname, String lname, String type, String empId, double payRate) {
		this.fName = fname;
		this.lName = lname;
		this.type = type;
		this.empId = empId;
		this.payRate = payRate;
	}
	
	/**
	 * Returns the first name of this employee.
	 * @return the first name of this employee.
	 */
	public String getFirstName() {
		return fName;
	}
	
	/**
	 * Returns the last name of this employee.
	 * @return the last name of this employee.
	 */
	public String getLastName() {
		return lName;
	}
	
	/**
	 * Returns the type of this employee.
	 * @return the type of this employee.
	 */
	public String getEmployeeType() {
		return type;
	}
	
	/**
	 * Returns the id of this employee.
	 * @return the id of this employee.
	 */
	public String getEmployeeId() {
		return empId;
	}
	
	/**
	 * Returns the hourly pay rate of this employee.
	 * @return the pay rate of this employee.
	 */
	public double getPayRate() {
		return payRate;
	}
	
	@Override
	public boolean updateEmployee(int flag, Object newInfo) {
		switch(flag) {
		case UPDATE_FIRST_NAME:
			if(!(newInfo instanceof String))
				return false;
			fName = (String) newInfo;
			break;
		case UPDATE_LAST_NAME:
			if(!(newInfo instanceof String))
				return false;
			lName = (String) newInfo;
			break;
		case UPDATE_TYPE:
			if(!(newInfo instanceof String))
				return false;
			type = (String) newInfo;
			break;
		case UPDATE_PAYRATE:
			if(!(newInfo instanceof Double))
				return false;
			payRate = (Double) newInfo;
			break;
		default: 
			return false;
		}
		return true;
	}
}
