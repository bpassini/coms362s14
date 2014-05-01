package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class WorkSchedule {
	
	private String scheduleId;
	private List<EmployeeShift> shifts;
	
	WorkSchedule(String scheduleId) {
		this.scheduleId = scheduleId;
		shifts = new ArrayList<EmployeeShift>();
	}
	public boolean addEntry(DateTime date, String employeeId, double start, double hours) {
		EmployeeShift es = new EmployeeShift(date, employeeId, start, hours);
		return shifts.add(es);
	}
	public String getId() {
		return scheduleId;
	}
	
	public List<EmployeeShift> getShifts() {
		return shifts;
	}
}
