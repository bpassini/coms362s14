package edu.iastate.cs362.ManagementSystem;

public class ManagementSystem implements ManagementSystemInterface {

	@Override
	public boolean createBudget() {
		return (new ManagementSystemDBSupport()).putBudget(new Budget());
	}

	@Override
	public boolean createPayroll() {
		return (new ManagementSystemDBSupport()).putPayroll(new Payroll());
	}

	@Override
	public boolean createEmployee(String name, String type, String empID,
			double payRate) {

		Employee e = new Employee(name, type, empID, payRate);
		return (new ManagementSystemDBSupport()).putEmployee(e);
	}

}
