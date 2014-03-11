package edu.iastate.cs362.ManagementSystem;

/**
 * A class that holds a name and double value.  This class will mostly be used by the Budget class to keep track of the different
 * revenues and expenses that make up a budget.  Each item listed in the budget (whether that be the revenue section or expense section)
 * will want a descriptor and a value. For example a category object might be created to hold the Lease/Mortgage Payment, the categoryName
 * would be "Lease/Mortgage Payment" and the value would be how much the resort expects to pay for their lease.
 * 
 * @author Bryan Passini
 *
 */
public class Category {
	/**
	 * The category name.
	 */
	private String categoryName;
	/**
	 * The value of the category.
	 */
	private double value;
	
	/**
	 * Creates a Category object given a category name and a value associated with that category.
	 * @param categoryName the name of the category.
	 * @param value the value of the category.
	 */
	public Category(String categoryName, double value) {
		this.categoryName = categoryName;
		this.value = value;
	}
	
	/**
	 * Returns the name of this category.
	 * @return the name of this category.
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * Returns the values associate with this category object.
	 * @return the value of this category.
	 */
	public double getCategoryValue() {
		return value;
	}
}
