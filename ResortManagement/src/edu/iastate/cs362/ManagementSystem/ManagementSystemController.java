package edu.iastate.cs362.ManagementSystem;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 * A class used to connect the user of the system to the Management System class.
 * 
 * Note: this class is a controller class.
 * 
 * @author Bryan Passini
 *
 */
public class ManagementSystemController implements ManagementSystemControllerInterface {

	@Override
	public boolean createBudget(String budgetId) {
		return new ManagementSystem().createBudget(budgetId);
	}

	@Override
	public boolean createPayroll(String payrollId, String startDate, String endDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
			return new ManagementSystem().createPayroll(payrollId, formatter.parseDateTime(startDate), formatter.parseDateTime(endDate));
		} catch(IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public boolean createEmployee(String fname, String lname, String type, String empID,
			double payRate) {

		return new ManagementSystem().createEmployee(fname, lname, type, empID, payRate);
	}
	
	@Override
	public boolean updatePayroll(String payrollId, int flag, Object newInfo) {
		return new ManagementSystem().updatePayroll(payrollId, flag, newInfo);
	}
	
	@Override
	public boolean updatePayrollRow(String payrollId, String employeeId, int flag, Object newInfo) {
		return new ManagementSystem().updatePayrollRow(payrollId, employeeId, flag, newInfo);
	}
	
	@Override
	public boolean addRevenueToBudget(String budgetId, String revenueName, double revenueAmount) {
		return new ManagementSystem().addRevenueToBudget(budgetId, revenueName, revenueAmount);
	}
	
	@Override
	public boolean addExpenseToBudget(String budgetId, String expenseName, double expenseAmount) {
		return new ManagementSystem().addExpenseToBudget(budgetId, expenseName, expenseAmount);
	}
	
	@Override
	public boolean addPayrollRow(String payrollId, String empName, String empId, double payRate, double regularHours, double overtimeHours) {
		return new ManagementSystem().addPayrollRow(payrollId, empName, empId, payRate, regularHours, overtimeHours);
	}
	
	@Override
	public boolean updateEmployee(String empId, int flag, Object newInfo) {
		return new ManagementSystem().updateEmployee(empId, flag, newInfo);
	}
	
	@Override
	public String viewBudget(String budgetId) {
		return new ManagementSystem().viewBudget(budgetId);
	}
	
	@Override
	public String viewPayroll(String payrollId) {
		return new ManagementSystem().viewPayroll(payrollId);
	}
}
