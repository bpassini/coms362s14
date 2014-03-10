package edu.iastate.cs362.Hotel;

import org.joda.time.format.DateTimeFormat;

import edu.iastate.cs362.Resort.Resort;

public class HotelController implements HotelControllerInterface {

	@Override
	public boolean createHotel(String hid, String name) {
		
		return (new Resort().createHotel(hid, name));
	}

	@Override
	public boolean addRoom(String hid, int beds, int occup, String desc, int rmid) {
		
		return (new Resort().addRoom(hid, beds, occup, desc, rmid));
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String notes) {
		
		return (new Resort().createRoomInvoice(hid, rmid, notes));
	}

	@Override
	public boolean createRoomReservation(String hid, String start, String end, Customer cust, Attribute attr) {
		
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		return (new Resort().createRoomReservation(hid, formatter.parseDateTime(start), formatter.parseDateTime(end), cust, attr));
	}
	
}
