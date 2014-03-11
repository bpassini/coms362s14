package edu.iastate.cs362.ManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public boolean putBudget(Budget b) {
		getConnection();
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			
			//Update Revenues
			ResultSet rsRev = query.executeQuery("select count(*) as count from Categories c where c.Budget='"+ b.getBudgetId() +"'" +
					"and c.CategoryType=" + REVENUE);
			if(!rsRev.next() || rsRev.getInt("count") < b.getRevenues().size()) {
				ArrayList<Category> revenues = b.getRevenues();
				Statement writeRev = connection.createStatement();
				writeRev.executeQuery("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType)" +
						"values(" + b.getBudgetId() + ", " + revenues.get(revenues.size() - 1).getCategoryName() + 
						"," + revenues.get(revenues.size() - 1).getCategoryValue() + ", " + REVENUE + ")");
				writeRev.close();
			}
			
			//Update Expenses
			ResultSet rsExp = query.executeQuery("select count(*) as count from Categories c where c.Budget='"+ b.getBudgetId() +"'" +
					"and c.CategoryType=" + EXPENSE);
			if(!rsExp.next() || rsExp.getInt("count") < b.getRevenues().size()) {
				ArrayList<Category> expenses = b.getExpenses();
				Statement writeExp = connection.createStatement();
				writeExp.executeQuery("insert into Categories(BudgetId, CategoryName, CategoryValue, CategoryType)" +
						"values(" + b.getBudgetId() + ", " + expenses.get(expenses.size() - 1).getCategoryName() + 
						"," + expenses.get(expenses.size() - 1).getCategoryValue() + ", " + EXPENSE + ")");
			}
			
			query.close();
			connection.close();
		} catch(SQLException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean putPayroll(Payroll p) {
		getConnection();
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			
			query.executeQuery("delete from Payroll  where PayrollId='" + p.getPayrollId() + "'");
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
			query.executeQuery("insert into Payroll(PayrollId, StartDate, EndDate) values(" + p.getPayrollId() + "," + p.getStartDate().toString(formatter) + "," +
					p.getEndDate().toString(formatter) + ")");
				
			ResultSet rsEmployeeInfo = query.executeQuery("select count(*) as count from EmployeeInfo e where e.PayrollId='" + p.getPayrollId() + "'");
			if(!rsEmployeeInfo.next() || rsEmployeeInfo.getInt("count") < p.getPayroll().size()) {
				EmployeeInfo empInfo = p.getPayroll().get(p.getPayroll().size() - 1);
				query.executeQuery("insert in EmployeeInfo(PayrollId, EmployeeId, RegularHours, OvertimeHours) values( "+ p.getPayrollId() + "," + empInfo.getEmployeeId() + "," +
						empInfo.getRegularHours() + "," + empInfo.getOvertimeHours() + ")");
			}
			
			query.close();
			connection.close();
		} catch(SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean putEmployee(Employee e) {
		getConnection();
		if(connection == null)
			return false;
		
		try {
			Statement query = connection.createStatement();
			
			query.executeQuery("delete from Employee where EmployeeId='" + e.getEmployeeId() + "'");
			query.executeQuery("insert into Employee(FirstName, LastName, EmployeeId, EmployeeType, Payrate) values(" + e.getFirstName() + "," + e.getLastName() + "," + 
					e.getEmployeeId() + "," + e.getEmployeeType() + "," + e.getPayRate() + ")");
			
			query.close();
			connection.close();
		} catch(SQLException sqle) {
			return false;
		}
		
		return false;
	}

	private void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://mysql.cs.iastate.edu";
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
	}
}
