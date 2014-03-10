package edu.iastate.cs362.Resort;

import edu.iastate.cs362.RentalCenter.RentalCenter;
import edu.iastate.cs362.Hotel.*;

public interface ResortDBSupportInterface {
	RentalCenter getRentalCenter(String rid);
	boolean putRentalCenter(RentalCenter r);
	Hotel getHotel(String hid);
	boolean putHotel(Hotel h);
}
