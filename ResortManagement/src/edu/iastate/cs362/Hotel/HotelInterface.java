package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.*;

/**
 * An interface to define what needs to be implemented in the Hotel class
 * 
 * @author Mike Pruszinske
 *
 */
public interface HotelInterface {
	boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String iid, String notes);
	boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
}
