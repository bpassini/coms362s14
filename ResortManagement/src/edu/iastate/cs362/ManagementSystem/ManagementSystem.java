package edu.iastate.cs362.ManagementSystem;

import org.joda.time.*;
/**
 * A class used to represent a management system for a resort.
 * 
 * @author Bryan Passini
 *
 */
public class ManagementSystem implements ManagementSystemInterface {
	
	@Override
	public boolean createBudget(String budgetId) {
		Budget b = new Budget(budgetId);
		return new ManagementSystemDBSupport().putBudget(b);
	}

	@Override
	public boolean createPayroll(String payrollId, DateTime startDate, DateTime endDate) {
		Payroll p = new Payroll(payrollId, startDate, endDate);
		return new ManagementSystemDBSupport().putPayroll(p);
	}

	@Override
	public boolean createEmployee(String fname, String lname, String type, String empID,
			double payRate) {

		Employee e = new Employee(fname, lname, type, empID, payRate);
		return new ManagementSystemDBSupport().putEmployee(e);
	}
	
	@Override
	public boolean updatePayroll(String payrollId, int flag, Object newInfo) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		if(p == null)
			return false;
		return p.updatePayroll(flag, newInfo) && new ManagementSystemDBSupport().putPayroll(p);
	}
	
	@Override
	public boolean updatePayrollRow(String payrollId, String employeeId, int flag, Object newInfo) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		if(p == null)
			return false;
		return p.updatePayrollRow(employeeId, flag, newInfo) && new ManagementSystemDBSupport().putPayroll(p); 
	}
	
	@Override
	public boolean addRevenueToBudget(String budgetId, String revenueName, double revenueAmount) {
		Budget b = new ManagementSystemDBSupport().getBudget(budgetId);
		if(b == null)
			return false;
		return b.addRevenue(revenueName, revenueAmount) && new ManagementSystemDBSupport().putBudget(b);
	}
	
	@Override
	public boolean addExpenseToBudget(String budgetId, String expenseName, double expenseAmount) {
		Budget b = new ManagementSystemDBSupport().getBudget(budgetId);
		if(b == null)
			return false;
		return b.addExpense(expenseName, expenseAmount) && new ManagementSystemDBSupport().putBudget(b);
	}
	
	@Override
	public boolean addPayrollRow(String payrollId, String empId, double regularHours, double overtimeHours) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		if(p == null)
			return false;
		return p.addPayrollRow(empId, regularHours, overtimeHours) && new ManagementSystemDBSupport().putPayroll(p); 
	}
	
	@Override
	public boolean updateEmployee(String empId, int flag, Object newInfo) {
		Employee e = new ManagementSystemDBSupport().getEmployee(empId);
		if(e == null)
			return false;
		return e.updateEmployee(flag, newInfo) && new ManagementSystemDBSupport().putEmployee(e);
	}
	
	@Override
	public String viewBudget(String budgetId) {
		Budget b = new ManagementSystemDBSupport().getBudget(budgetId);
		if(b == null)
			return "";
		return b.view();
	}
	
	@Override
	public String viewPayroll(String payrollId) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		if(p == null)
			return "";
		return p.view();
	}
}
