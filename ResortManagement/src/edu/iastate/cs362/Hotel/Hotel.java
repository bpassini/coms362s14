package edu.iastate.cs362.Hotel;

import org.joda.time.*;

public class Hotel implements HotelInterface{

	/**
	 * Hotel ID
	 */
	private String hid;
	
	/**
	 * Hotel name
	 */
	private String name;
	
	public Hotel(String hid, String name) {
		
		this.hid = hid;
		this.name = name;
	}
	
	
	@Override
	public boolean addRoom(int beds, int occup, String desc, int rmid) {
		
		Attribute a = new Attribute(beds, occup);
		Room rm = new Room(rmid, a, desc);
		
		return (new HotelDBSupport().putRoom(rm));
	}

	@Override
	public boolean createRoomInvoice(int rmid, String notes) {
		
		RoomInvoice ri = new RoomInvoice(rmid, notes);
		
		return (new HotelDBSupport().putRoomInvoice(ri));
	}

	@Override
	public boolean createRoomReservation(DateTime start, DateTime end, Customer cust, Attribute attr) {
			
		RoomReservation res = new RoomReservation(start, end, cust, attr);
		
		// Check here if hotel has room available during these dates?

		return (new HotelDBSupport().putRoomReservation(res));
	}
		
}	
