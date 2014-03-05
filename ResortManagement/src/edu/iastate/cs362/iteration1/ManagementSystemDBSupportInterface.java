package edu.iastate.cs362.iteration1;

public interface ManagementSystemDBSupportInterface {
	boolean putBudget(Budget b);
	boolean putPayroll(Payroll p);
	boolean putEmployee(Employee e);
}
