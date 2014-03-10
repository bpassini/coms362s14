package edu.iastate.cs362.Hotel;

import org.joda.time.*;

public interface HotelInterface {
	boolean addRoom(int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(DateTime start, DateTime end, Customer cust, Attribute attr);
}
