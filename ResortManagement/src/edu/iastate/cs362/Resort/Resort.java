package edu.iastate.cs362.Resort;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import edu.iastate.cs362.RentalCenter.*;
import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Hotel.Hotel;


public class Resort implements ResortInterface {

	@Override
	public boolean createRentalCenter(String rid, String name) {
		return new ResortDBSupport().putRentalCenter(new RentalCenter(rid, name));
	}

	@Override
	public boolean createHotel(String hid, String name) {
		
		return new ResortDBSupport().putHotel(new Hotel(hid, name));
	}

	@Override
	public boolean addEquipment(String rid, String eid, String equipType,
			double cost, String description) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		return rc.addEquipment(eid, equipType, cost, description);
	}

	@Override
	public boolean createEquipInvoice(String rid, String eid, String msg) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		return rc.createEquipInvoice(eid, msg);
	}

	@Override
	public boolean createRentalReservation(String rid, String eid,
			String cname, Date start, Date end) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		return rc.createRentalReservation(eid, cname, start, end);
	}

	@Override
	public boolean addRoom(String hid, int beds, int occup, String desc, int rmid) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		return h.addRoom(beds, occup, desc, rmid);
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String notes) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		return h.createRoomInvoice(rmid, notes);
	}

	@Override
	public boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		return h.createRoomReservation(start, end, cust, attr);
	}

}
