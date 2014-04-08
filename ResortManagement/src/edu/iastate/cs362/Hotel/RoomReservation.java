package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Represents a room reservation for a hotel room
 * 
 * @author Mike Pruszinske
 *
 */
public class RoomReservation implements RoomReservationInterface {
	
	/**
	 * Room reservation ID
	 */
	String rrid;
	
	/**
	 * Hotel ID
	 */
	String hid;
	
	/**
	 * Reservation start date
	 */
	DateTime start;
	
	/**
	 * Reservation end date
	 */
	DateTime end;
	
	/**
	 * Customer making reservation
	 */
	Customer cust;
	
	/**
	 * Customer's desired room attributes
	 */
	Attribute attr;	
	
	
	/**
	 * Creates a new room reservation with the given parameters
	 * 
	 * @param rrid - Room Reservation ID
	 * @param hid - Hotel ID
	 * @param start - start date
	 * @param end - end date
	 * @param cust - customer object
	 * @param attr - attribute object with desired room attributes
	 */
	public RoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
		
		this.rrid = rrid;
		this.hid = hid;
		this.start = start;
		this.end = end;
		this.cust = cust;
		this.attr = attr;
	}
	
	@Override
	public boolean updateRoomReservation(int flag, Object newInfo) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		switch(flag) {
		case UPDATE_HOTEL_ID:
			if(!(newInfo instanceof String))
				return false;
			hid = (String) newInfo;
			break;
		case UPDATE_START_DATE:
			if(!(newInfo instanceof DateTime))
				return false;
			try {
				start = formatter.parseDateTime((String) newInfo);
			}
			catch(IllegalArgumentException e) {
				return false;
			}
			break;
		case UPDATE_END_DATE:
			if(!(newInfo instanceof DateTime))
				return false;
			try {
				end = formatter.parseDateTime((String) newInfo);
			}
			catch(IllegalArgumentException e) {
				return false;
			}
			break;
		case UPDATE_CUSTOMER:
			if(!(newInfo instanceof Customer))
				return false;
			cust = (Customer) newInfo;
			break;
		case UPDATE_ATTRIBUTE:
			if(!(newInfo instanceof Attribute))
				return false;
			attr = (Attribute) newInfo;
			break;
		default:
			return false;
		}
		return true;
	}
	
	public String getRoomReservationID() {
		return rrid;
	}
	
	public void setRoomReservationID(String rrid) {
		this.rrid = rrid;
	}
	
	public String getHotelID() {
		return hid;
	}
	
	public void setHotelID(String hid) {
		this.hid = hid;
	}
	
	public DateTime getStart() {
		return start;
	}
	
	public void setStart(DateTime start) {
		this.start = start;
	}
	
	public DateTime getEnd() {
		return end;
	}
	
	public void setEnd(DateTime end) {
		this.end = end;
	}
	
	public Customer getCustomer() {
		return cust;
	}
	
	public void setCustomer(Customer cust) {
		this.cust = cust;
	}
	
	public int getCustomerID() {
		return cust.getCmid();
	}
	
	public void setCustomerID(int cmid) {
		this.cust.setCmid(cmid);
	}
	
	public String getFirstName() {
		return cust.getFirstName();
	}
	
	public void setFirstName(String name) {
		this.cust.setFirstName(name);
	}
	
	public String getLastName() {
		return cust.getLastName();
	}
	
	public void setLastName(String name) {
		this.cust.setLastName(name);
	}
	
	public ArrayList<String> getBeds() {
		return attr.beds;
	}
	
	public void setBeds(ArrayList<String> beds) {
		this.attr.beds = beds;
	}
	
	public int getNumGuests() {
		return attr.occupancy;
	}
	
	public void setNumGuests(int occupancy) {
		this.attr.occupancy = occupancy;
	}

}
