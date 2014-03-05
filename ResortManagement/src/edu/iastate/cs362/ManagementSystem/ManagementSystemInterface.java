package edu.iastate.cs362.ManagementSystem;

public interface ManagementSystemInterface {
	boolean createBudget(int numOfCategories, int profit);
	boolean createPayroll(Budget budget, int numOfEmps);
	boolean createEmployee(String name, String type, String empID, double payRate);
}
