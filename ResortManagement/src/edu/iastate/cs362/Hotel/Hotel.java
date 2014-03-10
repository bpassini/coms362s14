package edu.iastate.cs362.Hotel;

import java.util.Date;

public class Hotel implements HotelInterface{

	@Override
	public boolean addRoom(int beds, int occup, String desc, int rmid) {
		
		Room rm = new Room();
		
		rm.rmid = rmid;
		rm.desc = desc;
		rm.attr.numBeds = beds;
		rm.attr.occupancy = occup;
		
		HotelDBSupport s = new HotelDBSupport();
		
		return s.putRoom(rm);
	}

	@Override
	public boolean createRoomInvoice(int rmid, String notes) {
		
		RoomInvoice ri = new RoomInvoice();
		
		ri.rmid = rmid;
		ri.notes = notes;
		
		HotelDBSupport s = new HotelDBSupport();
		
		return s.putRoomInvoice(ri);
	}

	@Override
	public boolean createRoomReservation(String hotel, Date start, Date end, Customer cust, Attribute attr) {
			
		RoomReservation res = new RoomReservation();
		
		// if hotel has room available during these dates that matches desired attributes
			res.hotel = hotel;
			res.start = start;
			res.end = end;
			res.cust = cust;
			res.attr = attr;
			
		HotelDBSupport s = new HotelDBSupport();
		
		return s.putRoomReservation(res);
	}
		
}	
