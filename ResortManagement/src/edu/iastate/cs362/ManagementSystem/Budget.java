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
	 * Creates a budget object.
	 */
	public Budget() {
		revenues = new ArrayList<Category>();
		expenses = new ArrayList<Category>();
	}
		
	/**
	 * Private inner class used to hold the different categories of revenues and expenses.
	 * @author Bryan Passini
	 *
	 */
	private class Category {
		/**
		 * The category name.
		 */
		public String categoryName;
		/**
		 * The value of the category.
		 */
		public double value;
		
		/**
		 * Creates a Category object given a category name and a value associated with that category.
		 * @param categoryName the name of the category.
		 * @param value the value of the category.
		 */
		public Category(String categoryName, double value) {
			this.categoryName = categoryName;
			this.value = value;
		}
	}
}
