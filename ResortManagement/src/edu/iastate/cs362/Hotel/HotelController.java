package edu.iastate.cs362.Hotel;

import java.util.ArrayList;
import java.util.List;

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
	public boolean createRoomReservation(String rrid, String hid, String start, String end, Customer cust, int rmid) {
		
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		
		return (new Resort().createRoomReservation(rrid, hid, formatter.parseDateTime(start), formatter.parseDateTime(end), cust, rmid));
	}
	
	@Override
	public boolean updateRoomReservation(String hid, String rrid, int flag, Object newInfo) {
		return new Resort().updateRoomReservation(hid, rrid, flag, newInfo);
	}

	@Override
	public boolean updateHotel(String hid, int flag, Object u) {
		return new Resort().updateHotel(hid, flag, u);
	}

	@Override
	public boolean checkIntoRoom(String hid, String rrid) {
		return new Resort().checkIntoRoom(hid, rrid);
	}

	@Override
	public boolean checkOutOfRoom(String hid, String rrid) {
		return new Resort().checkOutOfRoom(hid, rrid);
	}

	@Override
	public boolean updateRoomInvoice(String hid, String iid, Object u, int flag) {
		return new Resort().updateRoomInvoice(hid, iid, u, flag);
	}

	@Override
	public List<Room> checkRoomAvailability(String hid, String start, String end) {
		
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		
		return new Resort().checkRoomAvailability(hid, formatter.parseDateTime(start), formatter.parseDateTime(end));
	}

	@Override
	public List<Room> searchRooms(String hid, Object u, int flag) {
		return new Resort().searchRooms(hid, u, flag);
	}
	
}
