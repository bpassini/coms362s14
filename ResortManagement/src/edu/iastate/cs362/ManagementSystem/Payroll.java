package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;

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
	private final ArrayList<Row> table;
	
	/**
	 * Creates a new payroll object with an empty payroll table.
	 */
	public Payroll() {
		//DO WE WANT DATES TO BE ASSOCIATED WITH A PAYROLL???
		//ID????
		table = new ArrayList<Row>();
	}
	
	/**
	 * Private inner class used to help represent the payroll table.
	 * 
	 * @author Bryan Passini
	 *
	 */
	private class Row {
		/**
		 * The name of the employee.
		 */
		public String empName;
		/**
		 * The hourly payrate of the employee.
		 */
		public double payRate;
		/**
		 * The number of regular hours worked by the employee
		 */
		public double regularHours;
		/**
		 * How much the employee is paid based on their number of regular hours.
		 * DO WE NEED THIS FIELD ----- CAN ALWAYS BE CALCULATED
		 */
		public double regularPay;
		/**
		 * The number of overtime hours worked by the employee.
		 */
		public double overtimeHours;
		/**
		 * How much the employee is paid based on their number of overtime hours.
		 * DO WE NEED THIS FIELD ----- CAN ALWAYS BE CALCULATED
		 */
		public double overtimePay;
		
		/**
		 * Creates an Row object given an employee and their hourly pay rate.
		 * @param empName the name of the employee this Row object represents.
		 * @param payRate the hourly pay rate of the employee this Row object represents.
		 */
		public Row(String empName, double payRate) {
			this.empName = empName;
			this.payRate = payRate;
			regularHours = 0;
			regularPay = 0;
			overtimeHours = 0;
			overtimePay = 0;
		}
	}
}
