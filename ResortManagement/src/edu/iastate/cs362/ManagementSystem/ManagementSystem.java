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
		return (new ManagementSystemDBSupport()).putBudget(new Budget(budgetId));
	}

	@Override
	public boolean createPayroll(String payrollId, DateTime startDate, DateTime endDate) {
		return (new ManagementSystemDBSupport()).putPayroll(new Payroll(payrollId, startDate, endDate));
	}

	@Override
	public boolean createEmployee(String name, String type, String empID,
			double payRate) {

		Employee e = new Employee(name, type, empID, payRate);
		return (new ManagementSystemDBSupport()).putEmployee(e);
	}

}
