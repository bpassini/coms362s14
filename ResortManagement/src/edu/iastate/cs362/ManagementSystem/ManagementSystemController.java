package edu.iastate.cs362.ManagementSystem;

import org.joda.time.*;
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
		return (new ManagementSystem()).createBudget(budgetId);
	}

	@Override
	public boolean createPayroll(String payrollId, String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		return (new ManagementSystem()).createPayroll(payrollId, formatter.parseDateTime(startDate), formatter.parseDateTime(endDate));
	}

	@Override
	public boolean createEmployee(String name, String type, String empID,
			double payRate) {

		return (new ManagementSystem()).createEmployee(name, type, empID, payRate);
	}

}