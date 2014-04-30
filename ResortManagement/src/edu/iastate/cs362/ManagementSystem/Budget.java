package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;

/**
 * Represents a budget that is created and used by a resort administrator.  The resort may have many different budgets.
 * 
 * @author Bryan Passini
 *
 */
public class Budget implements BudgetInterface {
	/**
	 * A list of the different revenues made by the resort.
	 */
	private ArrayList<Category> revenues;
	/**
	 * A list of the different expenses of the resort.
	 */
	private ArrayList<Category> expenses;
	/**
	 * The id of this budget.
	 */
	private String budgetId;
	
	/**
	 * Creates a budget object.
	 */
	public Budget(String budgetId) {
		this.budgetId = budgetId;
		revenues = new ArrayList<Category>();
		expenses = new ArrayList<Category>();
	}
	
	@Override
	public boolean addRevenue(String revenueName, double revenueAmount) {
		return revenues.add(new Category(revenueName, revenueAmount));
	}
	
	@Override
	public boolean addExpense(String expenseName, double expenseAmount) {
		return expenses.add(new Category(expenseName, expenseAmount));
	}
	
	/**
	 * Returns the id of this budget.
	 * @return the id of this budget.
	 */
	public String getBudgetId() {
		return budgetId;
	}
	
	/**
	 * Returns a list of category objects that define the revenues section of this budget.
	 * @return the list of category objects.
	 */
	public ArrayList<Category> getRevenues() {
		return revenues;
	}
	
	/**
	 * Returns a list of category objects that define the expenses section of this budget.
	 * @return the list of category objects.
	 */
	public ArrayList<Category> getExpenses() {
		return expenses;
	}
	
	@Override
	public String view() {
		String toRet = "Budget ID: " + budgetId + ":\n";
		
		toRet += "\tExpenses:\n";
		for(Category exp : expenses) {
			toRet += "\t\t" + exp.getCategoryName() + " " + exp.getCategoryValue() + "\n";
		}
		
		toRet += "\tRevenues:\n";
		for(Category rev : revenues) {
			toRet += "\t\t" + rev.getCategoryName() + " " + rev.getCategoryValue() + "\n";
		}
		
		return toRet;
	}
}
