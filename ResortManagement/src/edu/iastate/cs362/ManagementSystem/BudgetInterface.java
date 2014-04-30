package edu.iastate.cs362.ManagementSystem;

/**
 * Represents a budget that is created and used by a resort administrator.
 * 
 * @author Bryan Passini
 *
 */
public interface BudgetInterface {
	/**
	 * Adds a revenue to this budget.
	 * @param revenueName the name of this revenue.
	 * @param revenueAmount the amount of this revenue.
	 * @return true if the revenue was added successfully, false otherwise.
	 */
	boolean addRevenue(String revenueName, double revenueAmount);
	/**
	 * Add a expense to this budget.
	 * @param expenseName the name of this expense.
	 * @param expenseAmount the amount of this expense.
	 * @return true if the expense was added successfully, false otherwise.
	 */
	boolean addExpense(String expenseName, double expenseAmount);
}
