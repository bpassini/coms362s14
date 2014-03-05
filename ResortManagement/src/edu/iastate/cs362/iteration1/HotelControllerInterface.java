package edu.iastate.cs362.iteration1;

public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(int beds, int baths, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(String hotel, String start, Date end, Customer cust, List<Attribute> attr);
}
