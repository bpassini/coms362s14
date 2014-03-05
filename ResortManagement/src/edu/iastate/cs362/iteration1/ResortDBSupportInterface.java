package edu.iastate.cs362.iteration1;

public interface ResortDBSupportInterface {
	RentalCenter getRentalCenter(String rid);
	boolean putRentalCenter(RentalCenter r);
	Hotel getHotel(String hid);
}
