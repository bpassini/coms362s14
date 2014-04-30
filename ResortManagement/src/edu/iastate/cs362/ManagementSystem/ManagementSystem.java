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
		return p.updatePayroll(flag, newInfo) && new ManagementSystemDBSupport().putPayroll(p);
	}
	
	@Override
	public boolean updatePayrollRow(String payrollId, String employeeId, int flag, Object newInfo) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		return p.updatePayrollRow(employeeId, flag, newInfo) && new ManagementSystemDBSupport().putPayroll(p); 
	}
	
	@Override
	public boolean addRevenueToBudget(String budgetId, String revenueName, double revenueAmount) {
		Budget b = new ManagementSystemDBSupport().getBudget(budgetId);
		return b.addRevenue(revenueName, revenueAmount) && new ManagementSystemDBSupport().putBudget(b);
	}
	
	@Override
	public boolean addExpenseToBudget(String budgetId, String expenseName, double expenseAmount) {
		Budget b = new ManagementSystemDBSupport().getBudget(budgetId);
		return b.addRevenue(expenseName, expenseAmount) && new ManagementSystemDBSupport().putBudget(b);
	}
	
	@Override
	public boolean addPayrollRow(String payrollId, String empName, String empId, double payRate, double regularHours, double overtimeHours) {
		Payroll p = new ManagementSystemDBSupport().getPayroll(payrollId);
		return p.addPayrollRow(empName, empId, payRate, regularHours, overtimeHours) && new ManagementSystemDBSupport().putPayroll(p); 
	}
	
	@Override
	public boolean updateEmployee(String empId, int flag, Object newInfo) {
		Employee e = new ManagementSystemDBSupport().getEmployee(empId);
		return e.updateEmployee(flag, newInfo) && new ManagementSystemDBSupport().putEmployee(e);
	}
}
