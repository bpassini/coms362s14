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
	private final ArrayList<Category> revenues;
	/**
	 * A list of the different expenses of the resort.
	 */
	private final ArrayList<Category> expenses;
	/**
	 * The id of this budget.
	 */
	private final String budgetId;
	
	/**
	 * Creates a budget object.
	 */
	public Budget(String budgetId) {
		this.budgetId = budgetId;
		revenues = new ArrayList<Category>();
		expenses = new ArrayList<Category>();
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
}
