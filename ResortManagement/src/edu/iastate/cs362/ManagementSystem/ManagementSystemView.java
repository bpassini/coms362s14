package edu.iastate.cs362.ManagementSystem;

import java.util.Scanner;

public class ManagementSystemView {
	public static void main(String args[]) {
		System.out.println("Welcome to the Resort Management System!");
		System.out.println("What would you like to do?");
		System.out.println("\t1: create budget\n\t2: create payroll\n\t3: add employee\n\t4: update payroll\n\t-1: Exit");
		
		Scanner in = new Scanner(System.in);
		boolean returnCode = false;
		while(true) {
			int inputNum = 0;
			if(in.hasNextLine()) {
				inputNum = Integer.parseInt(in.nextLine().trim());
				if(inputNum != 1 && inputNum != 2 && inputNum != 3 && inputNum != 4 && inputNum != -1) {
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
			else
				break;
			
			if(!returnCode) {
				System.out.println("Operation failed, please try again.");
			}
			else {
				System.out.println("Operation succeeded!");
			}
			System.out.println("What would you like to do?");
			System.out.println("\t1: create budget\n\t2: create payroll\n\t3: add employee\n\t4: update payroll\n\t-1: Exit");
		}
		in.close();
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
			System.out.println("\t1: start date\n\t2: end date\n\t-1: Stop");
			if(in.hasNextInt())
				inputNum = in.nextInt();
		}
		
		String info = "";
		if(inputNum == 1) {
			System.out.print("Enter the new Start Date of this payroll (MM/dd/yyyy): ");
			if(in.hasNext())
				info = in.next().trim();
			return new ManagementSystemController().updatePayroll(payrollId, PayrollInterface.UPDATE_START_DATE, info);
		}
		else if(inputNum == 2) {
			System.out.print("Enter the new End Date of this payroll (MM/dd/yyyy): ");
			if(in.hasNext())
				info = in.next().trim();
			return new ManagementSystemController().updatePayroll(payrollId, PayrollInterface.UPDATE_END_DATE, info);
		}
		else
			return false;
	}
}