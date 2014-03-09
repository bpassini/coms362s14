package edu.iastate.cs362.ManagementSystem;

import java.util.ArrayList;

public class Budget implements BudgetInterface {
	private final ArrayList<Category> revenues;
	private final ArrayList<Category> expenses;
	
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
		
		public Category(String categoryName, double value) {
			this.categoryName = categoryName;
			this.value = value;
		}
	}
}
