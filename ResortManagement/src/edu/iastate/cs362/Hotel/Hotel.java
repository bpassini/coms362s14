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
	
	@Override
	public boolean updateRoomReservation(String reservationId, int flag, Object newInfo) {
		RoomReservation temp = null;
		for(RoomReservation rr : reservations) {
			if(rr.getRoomReservationID().equals(reservationId)) {
				temp = rr;
				break;
			}
		}
		//An room reservation with the given invoiceId was not found.
		if(temp == null)
			return false;
		if(temp.updateRoomReservation(flag, newInfo)) {
			//Place the updated room reservation at the end of the list and then return if the add was successful or not.
			return reservations.remove(temp) && reservations.add(temp);
		}
		return false;
	}
	
	
	@Override
	public boolean updateHotel(int flag, Object u) {
		
		if(u instanceof String) {
			if(flag == UPDATE_NAME) 
				name = (String) u;	
		}
		else
			return false;
	
		return true;
	}


	@Override
	public boolean checkIntoRoom(int rid, String rrid) {
		
		Room temp = null;
		for(Room r: rooms) {
			if(r.getRoomID() == rid)
			{
				temp = r;
				break;
			}
		}
		
		RoomReservation tempRes = null;
		for(RoomReservation rr: reservations) {
			if(rr.getRoomReservationID().equals(rrid)) {
				tempRes = rr;
				break;
			}
		}
		
		if(temp == null || tempRes == null) {
			return false;
		}
		
		else if(temp.setCheckedOut()) {
			tempRes.setRoomID(rid);
			boolean room = rooms.remove(temp) && rooms.add(temp);
			boolean res = reservations.remove(tempRes) && reservations.add(tempRes);
			return room && res;
		}
		
		else
			return false;
	}


	@Override
	public boolean checkOutOfRoom(int rid, String rrid) {
		
		Room temp = null;
		for(Room r: rooms) {
			if(r.getRoomID() == rid)
			{
				temp = r;
				break;
			}
		}
		
		RoomReservation tempRes = null;
		for(RoomReservation rr: reservations) {
			if(rr.getRoomReservationID().equals(rrid)) {
				tempRes = rr;
				break;
			}
		}
		
		if(temp == null || tempRes == null) {
			return false;
		}
		
		else if(temp.setAvailable()) {
			tempRes.setRoomID(0);
			boolean room = rooms.remove(temp) && rooms.add(temp);
			boolean res = reservations.remove(tempRes) && reservations.add(tempRes);
			return room && res;
		}
		
		else
			return false;
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
