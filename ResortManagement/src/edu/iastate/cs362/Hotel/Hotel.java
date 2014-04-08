package edu.iastate.cs362.Hotel;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.*;

/**
 * Represents a hotel created/used by hotel admin. Resort may have many hotels.
 * 
 * @author Mike Pruszinske
 *
 */
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
		rooms = new ArrayList<Room>();
		reservations = new ArrayList<RoomReservation>();
		invoices = new ArrayList<RoomInvoice>();
	}
	
	
	@Override
	public boolean addRoom(ArrayList<String> beds, int occup, String desc, int rmid) {
		
		Attribute a = new Attribute(beds, occup);
		Room rm = new Room(rmid, a, desc);
		
		return rooms.add(rm);
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String iid, String notes) {
		
		RoomInvoice ri = new RoomInvoice(hid, rmid, iid, notes);
		
		return invoices.add(ri);
	}

	@Override
	public boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
			
		RoomReservation res = new RoomReservation(rrid, hid, start, end, cust, attr);

		return reservations.add(res);
	}
	
	/**
	 * Get Hotel ID helper
	 * 
	 * @return - the hotel ID (hid)
	 */
	public String getID() {
		
		return hid;
	}
	
	/**
	 * Set Hotel ID helper
	 * 
	 * @param - the hotel ID (hid) to set
	 */
	public void setID(String hid) {
		
		this.hid = hid;
	}
	
	/**
	 * Get list of Rooms helper
	 * 
	 * @return - list of rooms in this hotel
	 */
	public List<Room> getRoomsList() {

		return rooms;
	}
	
	/**
	 * Get list of RoomReservations helper
	 * 
	 * @return - list of room reservations for this hotel
	 */
	public List<RoomReservation> getReservationsList() {
		
		return reservations;
	}

	/**
	 * Get list of RoomInvoices helper
	 * 
	 * @return - list of room invoices for this hotel
	 */
	public List<RoomInvoice> getInvoicesList() {
		
		return invoices;
	}
	
	/**
	 * Get hotel name helper
	 * 
	 * @return - name of Hotel
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Set hotel name helper
	 * 
	 * @param - hotel name to be set
	 */
	public void setName(String name) {
		
		this.name = name;
	}
		
}	
