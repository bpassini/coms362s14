package edu.iastate.cs362.ManagementSystem;

import java.util.Scanner;

public class ManagementSystemView {
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Welcome to the Resort Management System!");
		System.out.println("What would you like to do?");
		System.out.println("\t1: create budget\n\t2: create payroll\n\t3: add employee\n\t4: update payroll\n\t" +
				"5: update employee\n\t6: add revenues to a budget\n\t7: add expenses to budget\n\t8: add payrol row to a payroll\n\t" +
				"9: view a budget\n\t10: view a payroll\n\t11: assign a work schedule\n\t-1: Exit");
		
		Scanner in = new Scanner(System.in);
		boolean returnCode = false;
		while(true) {
			int inputNum = 0;
			if(in.hasNextLine()) {
				inputNum = Integer.parseInt(in.nextLine().trim());
				if(inputNum != 1 && inputNum != 2 && inputNum != 3 && inputNum != 4 && inputNum != -1 && 
						inputNum != 5 && inputNum != 6 && inputNum != 7 && inputNum != 8 && inputNum != 9 &&
						inputNum != 10 && inputNum != 11) {
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
				returnCode = addToBudget(1);
			else if(inputNum == 7)
				returnCode = addToBudget(2);
			else if(inputNum == 8)
				returnCode = addPayrollRow();
			else if(inputNum == 9)
				returnCode = viewBudget();
			else if(inputNum == 10)
				returnCode = viewPayroll();
			else if(inputNum == 11)
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
			System.out.println("\t1: create budget\n\t2: create payroll\n\t3: add employee\n\t4: update payroll\n\t" +
				"5: update employee\n\t6: add revenues to a budget\n\t7: add expenses to budget\n\t8: add payrol row to a payroll\n\t" +
				"9: view a budget\n\t10: view a payroll\n\t11: assign a work schedule\n\t-1: Exit");
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
	
	private static boolean updateEmployee() throws InterruptedException {
		Scanner in = new Scanner(System.in);
		String employeeId = "";
		
		System.out.println("What is the id of the employee you would like to update?");
		if(in.hasNextLine())
			employeeId = in.nextLine().trim();

		int inputNum = 0;
		System.out.println("What field of the employee would you like to update?");
		System.out.println("\t1: first name\n\t2: last name\n\t3: type\n\t4: payrate\n\t-1: Stop");
		if(in.hasNextInt())
			inputNum = in.nextInt();
		in.nextLine();
		
		while(inputNum != -1) {
			String info = "";
			boolean success = false;
			if(inputNum == 1) {
				System.out.print("Enter the new first name of this employee: ");
				if(in.hasNext())
					info = in.next().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_FIRST_NAME, info);
			}
			else if(inputNum == 2) {
				System.out.print("Enter the new last name of this employee: ");
				if(in.hasNext())
					info = in.next().trim();
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
				if(in.hasNext())
					info = in.next().trim();
				success = new ManagementSystemController().updateEmployee(employeeId, EmployeeInterface.UPDATE_PAYRATE, Double.parseDouble(info));
			}
			
			if(success)
				System.out.println("Operation Successful!");
			else
				System.out.println("Operation failed, please try again.");
			
			System.out.println("What field of the payroll would you like to update?");
			System.out.println("\t1: first name\n\t2: last name\n\t3: type\n\t4: payrate\n\t-1: Stop");

			if(in.hasNextInt())
				inputNum = in.nextInt();
			in.nextLine();
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
		System.out.println("\t1: add a " + (d == 1 ? "revenue" : "expense") + "\n\t-1: Stop");
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
			System.out.println("\t1: add a " + (d == 1 ? "revenue" : "expense") + "\n\t-1: Stop");
			if(in.hasNextInt())
				inputNum = in.nextInt();
			in.nextLine();
		}
		return true;
	}
	
	private static boolean addPayrollRow() {
		return false;
	}
	
	private static boolean viewBudget() {
		return false;
	}
	
	private static boolean viewPayroll() {
		return false;
	}
	
	private static boolean assignWorkSchedule() {
		//CAM PUT YOUR CODE HERE!!
		return false;
	}
}