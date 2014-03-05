package edu.iastate.cs362.iteration1;

public interface HotelInterface {
	boolean addRoom(int beds, int baths, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(String hotel, String startDate, String endDate, String cust, String attr);
}
