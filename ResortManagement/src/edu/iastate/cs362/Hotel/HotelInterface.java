package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.*;

public interface HotelInterface {
	boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
}
