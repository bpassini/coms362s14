package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.RentalCenter.EquipmentInvoice;

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
	
	/**
	 * Adds an employee info object to the payroll list.
	 * @param empName the name of the employee.
	 * @param empId the id of the employee.
	 * @param payRate the pay rate of the employee.
	 * @param regularHours the number of regular hours the employee has worked.
	 * @param overtimeHours the number of overtime hours this employee has worked.
	 */
	public void addEmployeeInfo(String empName, String empId, double payRate, double regularHours, double overtimeHours) {
		payroll.add(new EmployeeInfo(empName, empId, payRate, regularHours, overtimeHours));
	}
	
	@Override
	public boolean updatePayroll(int flag, Object newInfo) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		try {
			switch(flag) {
			case UPDATE_START_DATE:
				if(!(newInfo instanceof String))
					return false;
				startDate = formatter.parseDateTime((String) newInfo);
				break;
			case UPDATE_END_DATE:
				if(!(newInfo instanceof Customer))
					return false;
				endDate = formatter.parseDateTime((String) newInfo);
				break;
			default:
				return false;
			}
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updatePayrollRow(String employeeId, int flag, Object newInfo) {
		EmployeeInfo temp = null;
		for(EmployeeInfo ei : payroll) {
			if(ei.getEmployeeId().equals(employeeId)) {
				temp = ei;
				break;
			}
		}
		//An employee info object with the given invoiceId was not found.
		if(temp == null)
			return false;
		if(temp.updatePayrollRow(flag, newInfo)) {
			//Place the updated employee info object at the end of the list and then return if the add was successful or not.
			return payroll.remove(temp) && payroll.add(temp);
		}
		return false;
	}
}
