package edu.iastate.cs362.Resort;

import edu.iastate.cs362.RentalCenter.RentalCenter;
import edu.iastate.cs362.Hotel.*;

public interface ResortDBSupportInterface {
	/**
	 * Gets the specific RentalCenter from the Database
	 * @param rid - the RentalCenter id we wish to get by
	 * @return the correct RentalCenter
	 */
	RentalCenter getRentalCenter(String rid);
	/**
	 * Puts a RentalCenter into the Database
	 * @param r - the RentalCenter we wish to place
	 * @return true if it places the RentalCenter successfully, false otherwise
	 */
	boolean putRentalCenter(RentalCenter r);
	Hotel getHotel(String hid);
	boolean putHotel(Hotel h);
}
