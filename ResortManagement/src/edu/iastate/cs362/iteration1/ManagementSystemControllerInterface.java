package edu.iastate.cs362.iteration1;

public interface ManagementSystemControllerInterface {
	boolean createBudget(int numOfCategories, int profit);
	boolean createPayroll(Budget budget, int numOfEmps);
	boolean createEmployee(String name, String type, String empID, double payRate);
}
