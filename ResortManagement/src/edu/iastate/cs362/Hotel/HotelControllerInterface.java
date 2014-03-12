package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

/**
 * An interface to define what needs to be implemented in the HotelController class
 * 
 * @author Mike Pruszinske
 *
 */
public interface HotelControllerInterface {
	boolean createHotel(String hid, String name);
	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	boolean createRoomReservation(String rrid, String hid, String start, String end, Customer cust, Attribute attr);
}
