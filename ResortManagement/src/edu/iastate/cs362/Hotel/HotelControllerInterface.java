package edu.iastate.cs362.Hotel;

public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(String hid, int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, String start, String end, Customer cust, Attribute attr);
}
