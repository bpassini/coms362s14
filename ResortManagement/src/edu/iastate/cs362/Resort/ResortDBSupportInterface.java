package edu.iastate.cs362.Resort;

import edu.iastate.cs362.RentalCenter.RentalCenter;
import edu.iastate.cs362.Hotel.*;
/**
 * Interface for ResortDBSupport
 * 
 * @author Cameron Johnston
 * @author Mike Pruszinske
 * 
 */
public interface ResortDBSupportInterface {
	/**
	 * Gets the specific RentalCenter from the Database
	 * @param rId - the RentalCenter id we wish to get by
	 * @return the correct RentalCenter
	 */
	RentalCenter getRentalCenter(String rId);
	/**
	 * Puts a RentalCenter into the Database
	 * @param r - the RentalCenter we wish to place
	 * @return true if it places the RentalCenter successfully, false otherwise
	 */
	boolean putRentalCenter(RentalCenter r);
	
	/**
	 * Gets the specified Hotel from the database
	 * 
	 * @param hid - Hotel ID of desired hotel
	 * @return - the desired hotel with matching hid
	 */
	Hotel getHotel(String hid);
	
	/**
	 * Puts a Hotel into the database
	 * 
	 * @param h - the Hotel we wish to place in the database
	 * @return - true if Hotel is successfully placed in database, false otherwise
	 */
	boolean putHotel(Hotel h);
}
