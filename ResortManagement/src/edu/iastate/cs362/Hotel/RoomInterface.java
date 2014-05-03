package edu.iastate.cs362.Hotel;

/**
 * An interface to define what needs to be implemented in the Room class
 * 
 * @author Mike Pruszinske
 *
 */
public interface RoomInterface {

	/**
	 * Sets room to checked out.
	 * @return true if successful, false otherwise
	 */
	boolean setCheckedOut();
	
	/**
	 * Sets room to available.
	 * @return true if successful, false otherwise
	 */
	boolean setAvailable();
}
