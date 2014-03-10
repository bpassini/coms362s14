package edu.iastate.cs362.Hotel;

import java.util.Date;

public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(String hotel, Date start, Date end, Customer cust, Attribute attr);
}
