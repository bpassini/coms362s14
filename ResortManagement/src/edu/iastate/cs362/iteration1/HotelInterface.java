package edu.iastate.cs362.iteration1;

public interface HotelInterface {
	boolean addRoom(int beds, int baths, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(String hotel, Date start, Date end, Customer cust, List<Attribute> attr);
}
