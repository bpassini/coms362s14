package edu.iastate.cs362.ManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * A class used to connect the ManagementSystem to the database.  This class is used to separate the database
 * operations from the model.
 * 
 * @author Bryan Passini
 *
 */
public class ManagementSystemDBSupport implements ManagementSystemDBSupportInterface {
	/**
	 * Integer value used in the Database to represent the different between a Category object belonging to the 
	 * revenues or expenses List of the budget class.  The value represents the revenue section.
	 */
	private static final int REVENUE = 0;
	/**
	 * Integer value used in the Database to represent the different between a Category object belonging to the 
	 * revenues or expenses List of the budget class.  The value represents the revenue section.
	 */
	private static final int EXPENSE = 1;
	
	/**
	 * The JDBC connection to the database.
	 */
	private Connection connection;
	
	@Override
	public Budget getBudget(String budgetId) {
		Budget b = null;
		
		try {
			connection = this.getConnection();
			if(connection == null)
				b = null;
			else {
				Statement stmt = connection.createStatement();
				Statement stmtLists = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from Budget where BudgetId='" + budgetId + "'");
				if(rs.next()) {
					b = new Budget(budgetId);
					
					ResultSet rsLists = stmtLists.executeQuery("select * from Categories c where c.BudgetId='" + budgetId + "'");
					while(rsLists.next()) {
						if(rsLists.getInt("CategoryType") == REVENUE)
							b.addRevenue(rsLists.getString("CategoryName"), rsLists.getDouble("CategoryValue"));
						else if(rsLists.getInt("CategoryName") == EXPENSE)
							b.addExpense(rsLists.getString("CategoryName"), rsLists.getDouble("CategoryValue"));
					}
				}
				else {
					b = null;
				}
				stmt.close();
				stmtLists.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return b;
		}
		return b;
	}
	
	@Override
	public Employee getEmployee(String employeeId) {
		Employee e = null;
		
		try {
			connection = this.getConnection();
			if(connection == null)
				e = null;
			else {
				Statement stmt = connection.createStatement();
				Statement stmtLists = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from Employee where EmployeeId='" + employeeId + "'");
				if(rs.next()) {
					e = new Employee(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("EmployeeType"), 
																					employeeId, rs.getDouble("Payrate"));
				}
				else {
					e = null;
				}
				stmt.close();
				stmtLists.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return e;
		}
		return e;
	}
	
	@Override
	public boolean putBudget(Budget b) {
		if(this.getBudget(b.getBudgetId()) == null) 
			return writeBudget(b);
		else {
			if(this.updateBudget(b)) {
				if(b.getExpenses().size() > 0 ||  b.getRevenues().size() > 0) {
					return updateBudgetLists(b);
				}
				else 
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean putEmployee(Employee e) {
		if(this.getEmployee(e.getEmployeeId()) == null)
			return writeEmployee(e);
		return updateEmployee(e);
	}
	
	@Override 
	public Payroll getPayroll(String payrollId) {
		Payroll p = null;
		
		try {
			connection = this.getConnection();
			if(connection == null)
				p = null;
			else {
				Statement stmt = connection.createStatement();
				Statement stmtEmpInfo = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from Payroll where PayrollId='" + payrollId + "'");
				if(rs.next()) {
					DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
					p = new Payroll(payrollId, formatter.parseDateTime(rs.getString("StartDate")), formatter.parseDateTime(rs.getString("EndDate")));
					
					ResultSet rsEmpInfo = stmtEmpInfo.executeQuery("select * from EmployeeInfo ei, Employee e where ei.PayrollId='" + payrollId + "' and ei.EmployeeId=e.EmployeeId");
					while(rsEmpInfo.next()) {
						p.addPayrollRow(rsEmpInfo.getString("LastName") + ", " + rsEmpInfo.getString("FirstName"), rsEmpInfo.getString("EmployeeId"), rsEmpInfo.getDouble("Payrate"), rsEmpInfo.getDouble("RegularHours"), rsEmpInfo.getDouble("OvertimeHours"));
					}
				}
				else {
					p = null;
				}
				stmt.close();
				stmtEmpInfo.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return p;
		}
		return p;
	}
	
	@Override
	public boolean putPayroll(Payroll p) {
		if(this.getPayroll(p.getPayrollId()) == null)
			return writePayroll(p);
		else {
			if(this.updatePayroll(p)) {
				if(p.getPayroll().size() > 0)
					return updatePayrollList(p);
				else
					return true;
			}
		}
		return false;
	}
	
	/**
	 * A private helper method that inserts the given payroll object into the database.
	 * @param p the new payroll object to be inserted into the database.
	 * @return true if the insertion was successful, false otherwise.
	 */
	private boolean writePayroll(Payroll p) {
		try {
			connection = this.getConnection();
			if(connection == null)
				return false;
			else {
				Statement query = connection.createStatement();
				
				DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
				query.executeUpdate("insert into Payroll(PayrollId, StartDate, EndDate) values('" + p.getPayrollId() + "','" + p.getStartDate().toString(formatter) + "','" +
							p.getEndDate().toString(formatter) + "')");
					
				if(p.getPayroll().size() > 0) {
					for(EmployeeInfo empInfo : p.getPayroll()) {
						query.executeUpdate("insert in EmployeeInfo(PayrollId, EmployeeId, RegularHours, OvertimeHours) values('"+ p.getPayrollId() + "','" + empInfo.getEmployeeId() + "'," +
								empInfo.getRegularHours() + "," + empInfo.getOvertimeHours() + ")");
					}
				}
				
				query.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return false;
		}
		return true;
	}
	
	/**
	 * Update the given payroll object in the database.
	 * @param p the payroll object that needs to be updated.
	 * @return true if the update occurred successfully, false otherwise.
	 */
	private boolean updatePayroll(Payroll p) {
		connection = this.getConnection();
		
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			
			DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
			query.executeUpdate("update Payroll set StartDate='" + p.getStartDate().toString(formatter) + "', EndDate='" 
						+ p.getEndDate().toString(formatter) + "' where PayrollId='" + p.getPayrollId() + "'");
			
			query.close();
			connection.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	/**
	 * Updates a the list of payroll rows in the database.
	 * @param p the payroll that contains the rows that need to be updated.
	 * @return true if the update occurred successfully, false otherwise.
	 */
	private boolean updatePayrollList(Payroll p) {
		connection = this.getConnection();
		
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			Statement update = connection.createStatement();
			
			ResultSet rsEmployeeInfo = query.executeQuery("select count(*) as count from EmployeeInfo e where e.PayrollId='" + p.getPayrollId() + "'");
			if(!rsEmployeeInfo.next())
				return false;
			
			int difference = p.getPayroll().size() - rsEmployeeInfo.getInt("count");
			EmployeeInfo empInfo = p.getPayroll().get(p.getPayroll().size() - 1);
			if(difference == 1) {
				update.executeUpdate("insert in EmployeeInfo(PayrollId, EmployeeId, RegularHours, OvertimeHours) values('"+ p.getPayrollId() + "','" + empInfo.getEmployeeId() + "'," +
						empInfo.getRegularHours() + "," + empInfo.getOvertimeHours() + ")");
			}
			else if(difference == 0) {
				update.executeUpdate("update EmployeeInfo set RegularHours='" + empInfo.getRegularHours() + "', OvertimeHours='" + empInfo.getOvertimeHours() + "' where EmployeeId='" +
						empInfo.getEmployeeId() + "' and PayrollId='" + p.getPayrollId() + "'");
			}
			
			connection.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	/**
	 * A private helper method that inserts the given budget object into the database.
	 * @param b the new budget object to be inserted into the database.
	 * @return true if the insertion was successful, false otherwise.
	 */
	private boolean writeBudget(Budget b) {
		try {
			connection = this.getConnection();
			if(connection == null)
				return false;
			else {
				Statement query = connection.createStatement();
				
				query.executeUpdate("insert into Budget(BudgetId) values('" + b.getBudgetId() + "')");
				
				if(b.getRevenues().size() > 0) {
					for(Category rev : b.getRevenues()) {
						query.executeUpdate("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType)" +
								"values('" + b.getBudgetId() + "', '" + rev.getCategoryName() + "'," + rev.getCategoryValue() + ", " + REVENUE + ")");
					}
				}
				
				if(b.getExpenses().size() > 0) {
					for(Category exp : b.getExpenses()) {
						query.executeUpdate("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType)" +
								"values('" + b.getBudgetId() + "', '" + exp.getCategoryName() + "'," + exp.getCategoryValue() + ", " + EXPENSE + ")");
					}
				}
				
				query.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return false;
		}
		return true;
	}
	
	/**
	 * Updates the given budget in the database.
	 * @param b the budget to be updated.
	 * @return true if the budget was updated successfully, false otherwise.
	 */
	private boolean updateBudget(Budget b) {
		/*
		 * Right now there are no fields in budget besides the list (taken care of by updateBudgetLists), 
		 * so this method simply returns true for now.  If in the future budget is expanded this method
		 * may have more operations to perform.
		 */
		return true; 
	}
	
	/**
	 * Updates the revenue and expense lists in the database.
	 * @param b the budget that contains the lists to be updated.
	 * @return true if the update occurred successfully, false otherwise.
	 */
	private boolean updateBudgetLists(Budget b) {
		connection = this.getConnection();
		
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			Statement update = connection.createStatement();
			
			ResultSet rsLists = query.executeQuery("select count(c1.CategoryId) as expenseCount, count(c2.CategoryId) as revenueCount from Categories c1, Categories c2 " +
					"where c1.BudgetId='" + b.getBudgetId() + "' and c1.CategoryType=" + EXPENSE + " and c2.BudgetId='" + b.getBudgetId() + "' and c2.CategoryType=" + REVENUE + "");
			if(!rsLists.next())
				return false;
			
			//Update Revenue List
			int revSize = b.getRevenues().size();
			int revenueDifference = revSize - rsLists.getInt("revenueCount");
			Category rev = null;
			if(revSize > 0)
				rev = b.getRevenues().get(revSize - 1);
			if(revenueDifference == 1 && rev != null) {
				update.executeUpdate("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType) values('" + b.getBudgetId() + "', '" + rev.getCategoryName() + 
						"', " + rev.getCategoryValue() + ", " + REVENUE + ")");
			}
			else if(revenueDifference == 0 && rev != null) {
				update.executeUpdate("update Categories set CategoryValue=" + rev.getCategoryValue() +  " where CategoryName='" + rev.getCategoryName() + "' and CategoryType=" +
							REVENUE + "");
			}
			
			//Update Expense List
			int expSize = b.getExpenses().size();
			int expenseDifference = expSize - rsLists.getInt("expenseCount");
			Category exp = null;
			if(expSize > 0)
				exp = b.getExpenses().get(expSize - 1);
			if(expenseDifference == 1 && exp != null) {
				update.executeUpdate("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType) values('" + b.getBudgetId() + "', '" + exp.getCategoryName() + 
						"', " + exp.getCategoryValue() + ", " + EXPENSE + ")");
			}
			else if(expenseDifference == 0 && exp != null) {
				update.executeUpdate("update Categories set CategoryValue=" + exp.getCategoryValue() +  " where CategoryName='" + exp.getCategoryName() + "' and CategoryType=" + 
							EXPENSE + "");
			}
			
			connection.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	/**
	 * A private helper method that inserts the given employee object into the database.
	 * @param e the new employee object to be inserted into the database.
	 * @return true if the insertion was successful, false otherwise.
	 */
	private boolean writeEmployee(Employee e) {
		try {
			connection = this.getConnection();
			if(connection == null)
				return false;
			else {
				Statement query = connection.createStatement();
				
				query.executeUpdate("insert into Employee(FirstName, LastName, EmployeeId, EmployeeType, Payrate) values('" + e.getFirstName() + "','" + e.getLastName() + "','" + 
						e.getEmployeeId() + "','" + e.getEmployeeType() + "'," + e.getPayRate() + ")");
				
				query.close();
				connection.close();
			}
		} 
		catch(SQLException sqle) {
			return false;
		}
		return true;
	}
	
	/**
	 * Updates the given employee object in the database.
	 * @param e the employee object that needs to be updated.
	 * @return true if the update occurred successfully, false otherwise.
	 */
	private boolean updateEmployee(Employee e) {
		connection = this.getConnection();
		
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			
			query.executeUpdate("update Employee set FirstName='" + e.getFirstName() + "', LastName='" + e.getLastName() + "', EmployeeType='" + e.getEmployeeType() + 
							"', Payrate=" + e.getPayRate() + " where EmployeeId='" + e.getEmployeeId() + "'");
			
			query.close();
			connection.close();
		}
		catch(SQLException sqle) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the connection to the database.
	 * @return the connection to the database.
	 */
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://mysql.cs.iastate.edu:3306/db36202";
			String username = "u36202";
			String password = "K5f7k9eyw";
			
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			connection = null;
		} catch (SQLException e) {
			// Could not connect to the database
			connection = null;
		}
		return connection;
	}
}
