package edu.iastate.cs362.Resort;

public interface ResortDBSupportInterface {
	RentalCenter getRentalCenter(String rid);
	boolean putRentalCenter(RentalCenter r);
	Hotel getHotel(String hid);
}
