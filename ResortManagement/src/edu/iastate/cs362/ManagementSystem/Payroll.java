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
	 * The payroll.  This payroll is in the form of a table where the arraylist holds objects that represent each of the rows in the table and then the
	 * instance fields of the EmployeeInfo class create the different columns.
	 */
	private ArrayList<EmployeeInfo> payroll;
	/**
	 * The id of this payroll.
	 */
	private String payrollId;
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
	 * Returns the payroll.
	 * @return the payroll.
	 */
	public  ArrayList<EmployeeInfo> getPayroll() {
		return payroll;
	}
	
	/**
	 * Returns the id of this payroll object.
	 * @return the id of this payroll object.
	 */
	public String getPayrollId() {
		return payrollId;
	}
	
	/**
	 * Returns the start date of this payroll object.
	 * @return the start date.
	 */
	public DateTime getStartDate() {
		return startDate;
	}
	
	/**
	 * Returns the end date of this payroll object.
	 * @return the end date.
	 */
	public DateTime getEndDate() {
		return endDate;
	}
}
