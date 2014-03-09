package edu.iastate.cs362.ManagementSystem;

public interface ManagementSystemInterface {
	boolean createBudget();
	boolean createPayroll();
	boolean createEmployee(String name, String type, String empID, double payRate);
}
