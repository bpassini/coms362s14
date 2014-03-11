package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.*;

public class Hotel implements HotelInterface{

	/**
	 * List of rooms at this hotel
	 */
	private ArrayList<Room> rooms;
	
	/**
	 * List of reservations at this hotel
	 */
	private ArrayList<RoomReservation> reservations;
	
	/**
	 * List of invoices for this hotel
	 */
	private ArrayList<RoomInvoice> invoices;
	
	/**
	 * Hotel ID
	 */
	private String hid;
	
	/**
	 * Hotel name
	 */
	private String name;
	
	
	/**
	 * Create a new hotel using the given parameters
	 * 
	 * @param hid - Hotel ID
	 * @param name - Hotel name
	 */
	public Hotel(String hid, String name) {
		
		this.hid = hid;
		this.name = name;
	}
	
	
	@Override
	public boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid) {
		
		Attribute a = new Attribute(beds, occup);
		Room rm = new Room(rmid, a, desc);
		
		return rooms.add(rm);
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String notes) {
		
		RoomInvoice ri = new RoomInvoice(hid, rmid, notes);
		
		return invoices.add(ri);
	}

	@Override
	public boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
			
		RoomReservation res = new RoomReservation(hid, start, end, cust, attr);

		return reservations.add(res);
	}
		
}	
