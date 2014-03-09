package edu.iastate.cs362.ManagementSystem;

public class ManagementSystemController implements ManagementSystemControllerInterface {

	@Override
	public boolean createBudget() {
		return (new ManagementSystem()).createBudget();
	}

	@Override
	public boolean createPayroll() {
		return (new ManagementSystem()).createPayroll();
	}

	@Override
	public boolean createEmployee(String name, String type, String empID,
			double payRate) {

		return (new ManagementSystem()).createEmployee(name, type, empID, payRate);
	}

}
