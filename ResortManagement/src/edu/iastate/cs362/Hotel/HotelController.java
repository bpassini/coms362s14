package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.format.DateTimeFormat;

import edu.iastate.cs362.Resort.Resort;

/**
 * A class used to connect the user of the system to the Hotel class.
 * 
 * Note: this is a controller class.
 * 
 * @author Mike Pruszinske
 *
 */
public class HotelController implements HotelControllerInterface {

	@Override
	public boolean createHotel(String hid, String name) {
		
		return (new Resort().createHotel(hid, name));
	}

	@Override
	public boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid) {
		
		return (new Resort().addRoom(hid, beds, occup, desc, rmid));
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String iid, String notes) {
		
		return (new Resort().createRoomInvoice(hid, rmid, iid, notes));
	}

	@Override
	public boolean createRoomReservation(String rrid, String hid, String start, String end, Customer cust, Attribute attr) {
		
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		return (new Resort().createRoomReservation(rrid, hid, formatter.parseDateTime(start), formatter.parseDateTime(end), cust, attr));
	}
	
}
