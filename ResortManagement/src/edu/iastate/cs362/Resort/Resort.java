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
	public boolean createRentalCenter(String rId, String name) {
		return new ResortDBSupport().putRentalCenter(new RentalCenter(rId, name));
	}

	@Override
	public boolean createHotel(String hid, String name) {
		
		return new ResortDBSupport().putHotel(new Hotel(hid, name));
	}

	@Override
	public boolean addEquipment(String rId, String equipId, String equipType,
			double cost, String description) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc.addEquipment(equipId, equipType, cost, description))
			return (new ResortDBSupport().putRentalCenter(rc));
		else 
			return false;
	}

	@Override
	public boolean createEquipInvoice(String rId, String invoiceId, String equipId, String msg) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc.createEquipInvoice(invoiceId, equipId, msg))
			return (new ResortDBSupport().putRentalCenter(rc));
		else
			return false;
	}

	@Override
	public boolean createRentalReservation(String rId, String rentalId, String equipId,
			String cname, DateTime start, DateTime end) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc.createRentalReservation(rentalId, equipId, cname, start, end))
			return (new ResortDBSupport().putRentalCenter(rc));
		else
			return false;
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
