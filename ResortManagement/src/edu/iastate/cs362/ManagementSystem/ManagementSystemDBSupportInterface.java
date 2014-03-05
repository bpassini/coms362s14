package edu.iastate.cs362.ManagementSystem;

public interface ManagementSystemDBSupportInterface {
	boolean putBudget(Budget b);
	boolean putPayroll(Payroll p);
	boolean putEmployee(Employee e);
}
