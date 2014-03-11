package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, String start, String end, Customer cust, Attribute attr);
}
