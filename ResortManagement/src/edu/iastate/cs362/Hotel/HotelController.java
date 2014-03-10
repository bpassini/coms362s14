package edu.iastate.cs362.Hotel;

import java.util.Date;

import edu.iastate.cs362.Resort.Resort;

public class HotelController implements HotelControllerInterface {

	@Override
	public boolean createHotel(String hid, String name) {
		
		return (new Resort().createHotel(hid, name));
	}

	@Override
	public boolean addRoom(int beds, int occup, String desc, int rmid) {
		
		return (new Resort().addRoom(beds, occup, desc, rmid));
	}

	@Override
	public boolean createRoomInvoice(int rmid, String notes) {
		
		return (new Resort().createRoomInvoice(rmid, notes));
	}

	@Override
	public boolean createRoomReservation(String hotel, Date start, Date end,
			Customer cust, Attribute attr) {
		
		return (new Resort().createRoomReservation(hotel, start, end, cust, attr));
	}
	
}
