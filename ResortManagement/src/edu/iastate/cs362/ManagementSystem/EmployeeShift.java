package edu.iastate.cs362.ManagementSystem;

import org.joda.time.DateTime;

public class EmployeeShift {
	private DateTime date;
	private String employeeId;
	private double start;
	private double hours;
	
	EmployeeShift(DateTime date, String employeeId, double start, double hours) {
		this.date = date;
		this.employeeId = employeeId;
		this.start = start;
		this.hours = hours;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public double getStart() {
		return start;
	}
	
	public double getHours() {
		return hours;
	}
}
