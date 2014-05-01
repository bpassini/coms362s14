package edu.iastate.cs362.ManagementSystem;

import java.util.Scanner;

public class ManagementSystemView {
	public static void main(String args[]) {
		System.out.println("Welcome to the Resort Management System!");
		System.out.println("What would you like to do?");
		System.out.println("\t 1: create budget\n\t 2: create payroll\n\t 3: add employee\n\t 4: update payroll\n\t" +
				" 5: update employee\n\t 6: update payroll row\n\t 7: add revenues to a budget\n\t 8: add expenses to budget\n\t" +
				" 9: add payroll row to a payroll\n\t10: view a budget\n\t11: view a payroll\n\t12: assign a work schedule\n\t-1: Exit");
		
		Scanner in = new Scanner(System.in);
		boolean returnCode = false;
		while(true) {
			int inputNum = 0;
			if(in.hasNextLine()) {
				inputNum = Integer.parseInt(in.nextLine().trim());
				if(inputNum != 1 && inputNum != 2 && inputNum != 3 && inputNum != 4 && inputNum != -1 && 
						inputNum != 5 && inputNum != 6 && inputNum != 7 && inputNum != 8 && inputNum != 9 &&
						inputNum != 10 && inputNum != 11 && inputNum != 12) {
					System.out.println("Input invalid, please try again.");
					continue;
				}
			}
			if(inputNum == 1)
				returnCode = createBudget();
			else if(inputNum == 2)
				returnCode = createPayroll();
			else if(inputNum == 3)
				returnCode = addEmployee();
			else if(inputNum == 4)
				returnCode = updatePayroll();
			else if(inputNum == 5)
				returnCode = updateEmployee();
			else if(inputNum == 6)
				returnCode = updatePayrollRow();
			else if(inputNum == 7)
				returnCode = addToBudget(1);
			else if(inputNum == 8)
				returnCode = addToBudget(2);
			else if(inputNum == 9)
				returnCode = addPayrollRow();
			else if(inputNum == 10)
				returnCode = view(1);
			else if(inputNum == 11)
				returnCode = view(2);
			else if(inputNum == 12)
				returnCode = assignWorkSchedule();
			else
				break;
			
			if(!returnCode) {
				System.out.println("Operation failed, please try again.");
			}
			else {
				System.out.println("Operation succeeded!");
			}
			System.out.println("What would you like to do?");
			System.out.println("\t 1: create budget\n\t 2: create payroll\n\t 3: add employee\n\t 4: update payroll\n\t" +
					" 5: update employee\n\t 6: update payroll row\n\t 7: add revenues to a budget\n\t 8: add expenses to budget\n\t" +
					" 9: add payroll row to a payroll\n\t10: view a budget\n\t11: view a payroll\n\t12: assign a work schedule\n\t-1: Exit");
		}
	}

	private static boolean createBudget() {
		return new ManagementSystemController().createBudget("bud" + System.currentTimeMillis() + "");
	}
	
	private static boolean createPayroll() {
		Scanner in = new Scanner(System.in);
		String start, end = start = "";
		
		System.out.println("What is the start date of this payroll? (MM/dd/yyyy)");
		if(in.hasNextLine())
			start = in.nextLine().trim();
		System.out.println("What is the end date of this payroll? (MM/dd/yyyy)");
		if(in.hasNextLine())
			end = in.nextLine().trim();
		
		return new ManagementSystemController().createPayroll("pay" + System.currentTimeMillis() + "", start, end);
	}
	
	private static boolean addEmployee() {
		Scanner in = new Scanner(System.in);
		String fname, lname, type = lname = fname = "";
		double payRate = 0.0;
		
		System.out.println("What is the first name of your new employee?");
		if(in.hasNextLine())
			fname = in.nextLine().trim();
		System.out.println("What is the last name of your new employee?");
		if(in.hasNextLine())
			lname = in.nextLine();
		System.out.println("What is the employee type of your new employee?");
		if(in.hasNextLine())
			type = in.nextLine().trim();
		System.out.println("What is the hourly pay rate of your new employee?");
		if(in.hasNextLine())
			payRate = Double.parseDouble(in.nextLine().trim());
		
		return new ManagementSystemController().createEmployee(fname, lname, type, "pay" + System.currentTimeMillis() + "", payRate);
	}
	
	private static boolean updatePayroll() {
		Scanner in = new Scanner(System.in);
		String payrollId = "";
		
		System.out.println("What is the id of the payroll you would like to update?");
		if(in.hasNextLine())
			payrollId = in.nextLine().trim();

		int inputNum = 0;
		while(inputNum != -1 && inputNum != 1 && inputNum != 2) {
			System.out.println("What field of the payroll would you like to update?");
			System.out.println("\t 1: start date\n\t 2: end date\n\t-1: Stop");
			if(in.hasNextLine())
				inputNum = Integer.parseInt(in.nextLine());
		}
		
		String info = "";
		if(inputNum == 1) {
			System.out.print("Enter the new Start Date of this payroll (MM/dd/yyyy): ");
			if(in.hasNextLine())
				info = in.nextLine().trim();
			return new ManagementSystemController().updatePayroll(payrollId, PayrollInterface.UPDATE_START_DATE, info);
		}
		else if(inputNum == 2) {
			System.out.print("Enter the new End Date of this payroll (MM/dd/yyyy): ");
			if(in.hasNextLine())
				info = in.nextLine().trim();
			return new ManagementSystemController().updatePayroll(payrollId, PayrollInterface.UPDATE_END_DATE, info);
		}
		else
			return false;
	}
	
	private static boolean updateEmployee() {
		Scanner in = new Scanner(System.in);
		String employeeId = "";
		
		System.out.println("What is the id of the employee you would like to update?");
		if(in.hasNextLine())
			employeeId = in.nextLine().trim();

		int inputNum = 0;
		System.out.println("What field of the employee would you like to update?");
		System.out.println("\t 1: first name\n\t 2: last name\n\t 3: type\n\t 4: payrate\n\t-1: Stop");
		if(in.hasNextInt())
			inputNum = in.nextInt();
		in.nextLine();
		
		while(inputNum != -1) {
			String info = "";
			boolean success = false;
			if(inputNum == 1) {
				System.out.print("Enter the new first name of this employee: ");
				if(in.hasNextLine())
					info = in.nextLine().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_FIRST_NAME, info);
			}
			else if(inputNum == 2) {
				System.out.print("Enter the new last name of this employee: ");
				if(in.hasNextLine())
					info = in.nextLine().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_LAST_NAME, info);
			}
			else if(inputNum == 3) {
				System.out.print("Enter the new type of this employee: ");
				if(in.hasNextLine())
					info = in.nextLine().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_TYPE, info);
			}
			else if(inputNum == 4) {
				System.out.print("Enter the new payrate of this employee: ");
				if(in.hasNextLine())
					info = in.nextLine().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_PAYRATE, Double.parseDouble(info));
			}
			
			if(success)
				System.out.println("Operation Successful!");
			else
				System.out.println("Operation failed, please try again.");
			
			System.out.println("What field of the payroll would you like to update?");
			System.out.println("\t 1: first name\n\t 2: last name\n\t 3: type\n\t 4: payrate\n\t-1: Stop");

			if(in.hasNextInt())
				inputNum = in.nextInt();
			in.nextLine();
		}
		return true;
	}
	
	private static boolean updatePayrollRow() {
			Scanner in = new Scanner(System.in);
			String payrollId, employeeId = payrollId = "";
			
			System.out.println("What is the id of the payroll you would like to update?");
			if(in.hasNextLine())
				payrollId = in.nextLine().trim();

			int inputNum = 0;
			System.out.println("What is the id of the employee that you would like to update?");
			if(in.hasNextLine())
				employeeId = in.nextLine().trim();
			
			while(true) {
				while(true) {
					System.out.println("What would you like to do?");
					System.out.println("\t 1: update the row with this employee id" + "\n\t-1: change employee id's or stop");
					if(in.hasNextInt())
						inputNum = in.nextInt();
					in.nextLine();
					
					if(inputNum == -1)
						break;
					
					int inNum = 0;
					System.out.println("What field of this row would you like to update?");
					System.out.println("\t 1: regular hours" + "\n\t2: overtime hours" + "\n\t-1: stop");
					if(in.hasNextInt())
						inNum = in.nextInt();
					in.nextLine();
					
					double info = 0.0;
					boolean success = false;
					if(inNum == 1) {
						System.out.print("Enter the new number of regular hours: ");
						if(in.hasNextLine())
							info = Double.parseDouble(in.nextLine().trim());
						success = new ManagementSystemController().updatePayrollRow(payrollId, employeeId, EmployeeInfoInterface.UPDATE_REGULAR_HOURS, info);
					}
					else if(inNum == 2) {
						System.out.print("Enter the new number of overtime hours: ");
						if(in.hasNextLine())
							info = Double.parseDouble(in.nextLine().trim());
						success = new ManagementSystemController().updatePayrollRow(payrollId, employeeId, EmployeeInfoInterface.UPDATE_OVERTIME_HOURS, info);
					}
					
					if(success)
						System.out.println("Operation Successful!");
					else
						System.out.println("Operation failed, please try again.");
				}
				System.out.println("What would you like to do?\n\t 1: enter new employee id\n\t-1: exit");
				if(in.hasNextLine())
					inputNum = Integer.parseInt(in.nextLine().trim());
				
				if(inputNum == -1)
					break;
				
				System.out.println("What is the id of the employee that you would like to update?");
				if(in.hasNextLine())
					employeeId = in.nextLine().trim();
			}
			return true;
	}
	
	private static boolean addToBudget(int d) {
		Scanner in = new Scanner(System.in);
		String budgetId = "";
		
		System.out.println("What is the id of the budget you would like to update?");
		if(in.hasNextLine())
			budgetId = in.nextLine().trim();

		int inputNum = 0;
		System.out.println("What would you like to do?");
		System.out.println("\t 1: add a " + (d == 1 ? "revenue" : "expense") + "\n\t-1: Stop");
		if(in.hasNextInt())
			inputNum = in.nextInt();
		in.nextLine();
		
		while(inputNum != -1) {
			boolean success = false;
			if(inputNum == 1) {
				String name = "";
				double value = 0.0;
				System.out.print("Enter name of the " + (d == 1 ? "revenue" : "expense") + ": ");
				if(in.hasNextLine())
					name = in.nextLine().trim();
				System.out.print("Enter value of the " + (d == 1 ? "revenue" : "expense") + ": ");
				if(in.hasNextLine())
					value = Double.parseDouble(in.nextLine().trim());
				if(d == 1)
					success = new ManagementSystemController().addRevenueToBudget(budgetId, name, value);
				if(d == 2)
					success = new ManagementSystemController().addExpenseToBudget(budgetId, name, value);
			}
			
			if(success)
				System.out.println("Operation Successful!");
			else
				System.out.println("Operation failed, please try again.");
			
			System.out.println("What would you like to do?");
			System.out.println("\t 1: add a " + (d == 1 ? "revenue" : "expense") + "\n\t-1: Stop");
			if(in.hasNextInt())
				inputNum = in.nextInt();
			in.nextLine();
		}
		return true;
	}
	
	private static boolean addPayrollRow() {
		Scanner in = new Scanner(System.in);
		String payrollId, empId = payrollId = "";
		double  regularHours, overtimeHours = regularHours = 0.0;
		
		System.out.println("What is the id of the payroll you would like to add a row to?");
		if(in.hasNextLine())
			payrollId = in.nextLine().trim();

		System.out.println("What is the employee ID you would like to add to the payroll?");
		if(in.hasNextLine())
			empId = in.nextLine();
		System.out.println("How many hours, of regular pay, has this employee worked?");
		if(in.hasNextLine())
			regularHours = Double.parseDouble(in.nextLine().trim());
		System.out.println("How many hours, of overtime pay, has this employee worked?");
		if(in.hasNextLine())
			overtimeHours = Double.parseDouble(in.nextLine().trim());
		
		return new ManagementSystemController().addPayrollRow(payrollId, empId, regularHours, overtimeHours);
	}
	
	private static boolean view(int i) {
		Scanner in = new Scanner(System.in);
		String id, toPrint = id = "";
		
		System.out.println("What is the id of the " + (i == 1 ? "budget" : "payroll") + " you would like to view?");
		if(in.hasNextLine())
			id = in.nextLine().trim();

		if(i == 1)
			toPrint =  new ManagementSystemController().viewBudget(id);
		else if(i == 2)
			toPrint = new ManagementSystemController().viewPayroll(id);
		
		System.out.println(toPrint);
		return true;
	}
	
	private static boolean assignWorkSchedule() {
		
		Scanner in = new Scanner(System.in);
		String date, empId, scheduleId = empId = date = "";
		double start, hours = start = 0.0;
		
		System.out.println("Enter a new schedule id.");
		if(in.hasNextLine())
			scheduleId = in.nextLine().trim();
		
		while(true) {
			System.out.println("What date would you like to add a shift to? (MM/dd/yyyy)");
			
			if(in.hasNextLine())
				date = in.nextLine().trim();
			System.out.println("Enter the employee id to schedule work for.");
			if(in.hasNextLine())
				empId = in.nextLine().trim();
			
			System.out.println("Enter the start time of the shift. (hh:mm) am/pm");
			
			if(in.hasNextLine()) {
				String s = in.nextLine();
				
				double add = 0;
				
				String time = s.split(" ")[1];
				s = s.split(" ")[0];
				
				String[] arr = s.split(":");
				if(arr.length == 2) {
					start += Double.parseDouble(arr[0]);
					if((start != 12 && time.equalsIgnoreCase("pm"))) {
						add = 12;
					}
					start += Double.parseDouble(arr[1])/60.0;
					
					start += add;
				}
			}
			
			System.out.println("Enter the end time of the shift. (hh:mm) am/pm");
			
			double end = 0;
			if(in.hasNextLine()) {
				String s = in.nextLine();
				double add = 0;
				
				String time = s.split(" ")[1];
				
				s = s.split(" ")[0];
				
				String[] arr = s.split(":");
				if(arr.length == 2) {
					end += Double.parseDouble(arr[0]);
					if((end != 12 && time.equalsIgnoreCase("pm"))) {
						add = 12;
					}
					end += Double.parseDouble(arr[1])/60.0;
					end += add;
				}
			}
			
			hours = Math.abs(end - start);
			
			boolean b = new ManagementSystemController().assignWorkSchedule(scheduleId, date, empId, start, hours);
			String ans = "";
			if(b) {
				System.out.println("Would you like to add another shift? (y/n)");
				if(in.hasNextLine())
					ans = in.nextLine().trim();
				if(!(ans.equalsIgnoreCase("y") || ans.startsWith("y") || ans.startsWith("Y")))
					break;
			}
			else
				return false;
			
		}
		
		return true;
	}
}
