package edu.iastate.cs362.ManagementSystem;

/**
 * This class is used to keep the each employees information that is relevant to the payroll.
 * 
 * @author Bryan Passini
 *
 */
public class EmployeeInfo {
	/**
	 * The name of the employee.
	 */
	private String empName;
	/**
	 * The id of the employee
	 */
	private String empId;
	/**
	 * The hourly pay rate of the employee.
	 */
	private double payRate;
	/**
	 * The number of regular hours worked by the employee
	 */
	private double regularHours;
	/**
	 * The number of overtime hours worked by the employee.
	 */
	private double overtimeHours;

	
	/**
	 * Creates an EmployeeInfo object given an employee name, id and their hourly pay rate.
	 * @param empName the name of the employee this Row object represents.
	 * @param payRate the hourly pay rate of the employee this Row object represents.
	 */
	public EmployeeInfo(String empName, String empId, double payRate) {
		this(empName, empId, payRate, 0, 0);
	}
	
	/**
	 * Creates an EmployeeInfo object given an employee name, employee id, their pay rate, the number of regular hours worked by this employee
	 * and the number of overtime hours worked by this employee.
	 * @param empName the name of the employee.
	 * @param empId the id of the employee.
	 * @param payRate the hourly pay rate of the employee.
	 * @param regularHours the number of regular hours worked by the employee.
	 * @param overtimeHours the number of overtime hours worked by the employee.
	 */
	public EmployeeInfo(String empName, String empId, double payRate, double regularHours, double overtimeHours) {
		this.empName = empName;
		this.empId = empId;
		this.payRate = payRate;
		this.regularHours = regularHours;
		this.overtimeHours = overtimeHours;
	}
	
	/**
	 * Returns the name of the employee.
	 * @return the name of the employee.
	 */
	public String getEmployeeName() {
		return empName;
	}
	
	/**
	 * Returns the id of the employee.
	 * @return the id of the employee.
	 */
	public String getEmployeeId() {
		return empId;
	}
	
	/**
	 * Returns the pay rate of the employee.
	 * @return the pay rate of the employee.
	 */
	public double getPayRate() {
		return payRate;
	}
	
	/**
	 * Returns the number of overtime hours that the employee has worked.
	 * @return the number of overtime hours worked.
	 */
	public double getRegularHours() {
		return regularHours;
	}
	
	/**
	 * Returns the number of regular hours that the employee has worked.
	 * @return the number of regular hours worked.
	 */
	public double getOvertimeHours() {
		return overtimeHours;
	}
}
