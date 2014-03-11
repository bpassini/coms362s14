package edu.iastate.cs362.ManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putEmployee(Employee e) {
		// TODO Auto-generated method stub
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
