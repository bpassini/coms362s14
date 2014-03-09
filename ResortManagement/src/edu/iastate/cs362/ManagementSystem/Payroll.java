package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;

public class Payroll implements PayrollInterface {
	private final ArrayList<Row> table;
	
	public Payroll() {
		table = new ArrayList<Row>();
	}
	
	private class Row {
		public String empName;
		public double payRate;
		public double regularHours;
		public double regularPay;
		public double overtimeHours;
		public double overtimePay;
		
		public Row(String empName, double payRate) {
			this.empName = empName;
			this.payRate = payRate;
			regularHours = 0;
			regularPay = 0;
			overtimeHours = 0;
			overtimePay = 0;
		}
	}
}
