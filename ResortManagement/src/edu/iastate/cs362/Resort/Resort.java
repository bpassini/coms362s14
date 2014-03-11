package edu.iastate.cs362.Resort;

import java.util.ArrayList;

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
	public boolean createEquipInvoice(String rid, String invoiceId, String eid, String msg) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);

		return rc.createEquipInvoice(invoiceId, eid, msg);
	}

	@Override
	public boolean createRentalReservation(String rid, String rentalId, String eid,
			String cname, DateTime start, DateTime end) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		return rc.createRentalReservation(rentalId, eid, cname, start, end);
	}

	@Override
	public boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		
		if(h.addRoom(beds, occup, desc, rmid) == false)
			return false;
		
		return (new ResortDBSupport().putHotel(h));
	}

	@Override
	public boolean createRoomInvoice(String hid, int rmid, String notes) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		
		if(h.createRoomInvoice(rmid, notes) == false)
			return false;
		
		return(new ResortDBSupport().putHotel(h));
	}

	@Override
	public boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		
		if(h.createRoomReservation(start, end, cust, attr) == false)
			return false;
		
		return(new ResortDBSupport().putHotel(h));
	}

}
