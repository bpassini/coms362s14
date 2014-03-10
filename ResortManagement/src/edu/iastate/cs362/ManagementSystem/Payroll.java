package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;
import org.joda.time.*;

/**
 * Represents a payroll that is used by the resort to track the earnings of each employee. A resort may have more than one payroll.
 * 
 * @author Bryan Passini
 *
 */
public class Payroll implements PayrollInterface {
	/**
	 * A list of Row objects.  This list creates a payroll table where each Row object represents a row in the
	 * table and each Row attribute represents a column in the table.
	 */
	private final ArrayList<EmployeeInfo> payroll;
	/**
	 * The id of this payroll.
	 */
	private final String payrollId;
	/**
	 * The start date of this payroll.
	 */
	private DateTime startDate;
	/**
	 * The end date of this payroll.
	 */
	private DateTime endDate;
	
	/**
	 * Creates a new payroll object with an empty payroll table.
	 * @param payrollId The id of this payroll.
	 * @param startDate The start date of this payroll.
	 * @param endDate The end date of this payroll.
	 */
	public Payroll(String payrollId, DateTime startDate, DateTime endDate) {
		payroll = new ArrayList<EmployeeInfo>();
		this.payrollId = payrollId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Private inner class used to help represent the payroll.  This class is used to keep the each employees information that is relevant to the payroll.
	 * 
	 * @author Bryan Passini
	 *
	 */
	private class EmployeeInfo {
		/**
		 * The name of the employee.
		 */
		public String empName;
		/**
		 * The id of the employee
		 */
		public String empId;
		/**
		 * The hourly pay rate of the employee.
		 */
		public double payRate;
		/**
		 * The number of regular hours worked by the employee
		 */
		public double regularHours;
		/**
		 * The number of overtime hours worked by the employee.
		 */
		public double overtimeHours;

		
		/**
		 * Creates an Row object given an employee and their hourly pay rate.
		 * @param empName the name of the employee this Row object represents.
		 * @param payRate the hourly pay rate of the employee this Row object represents.
		 */
		public EmployeeInfo(String empName, String empId, double payRate) {
			this.empName = empName;
			this.empId = empId;
			this.payRate = payRate;
			regularHours = 0;
			overtimeHours = 0;
		}
	}
}
