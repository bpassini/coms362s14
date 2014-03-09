package edu.iastate.cs362.ManagementSystem;

public class Employee implements EmployeeInterface {
	private String name;
	private String type;
	private String empId;
	private double payRate;
	
	public Employee(String name, String type, String empId, double payRate) {
		this.name = name;
		this.type = type;
		this.empId = empId;
		this.payRate = payRate;
	}
	
	private class Name {
		public String first;
		public String last;
		public String middle;
		
		public Name(String first, String middle, String last) {
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
	}
}
