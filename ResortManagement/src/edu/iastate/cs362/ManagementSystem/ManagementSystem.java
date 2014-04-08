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
}
