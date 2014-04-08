package edu.iastate.cs362.Resort;

import java.util.ArrayList;

import org.joda.time.*;

import edu.iastate.cs362.RentalCenter.*;
import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Hotel.Hotel;

/**
 * Represents a resort.
 * 
 * @author Cameron Johnston
 * @author Mike Pruszinske
 * @author Bryan Passini
 *
 */
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
		if(rc != null && rc.addEquipment(equipId, equipType, cost, description))
			return (new ResortDBSupport().putRentalCenter(rc));
		else 
			return false;
	}

	@Override
	public boolean createEquipInvoice(String rId, String invoiceId, String equipId, String msg) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc != null && rc.createEquipInvoice(invoiceId, equipId, msg))
			return (new ResortDBSupport().putRentalCenter(rc));
		else
			return false;
	}
	
	@Override
	public boolean updateEquipmentInvoice(String rId, String invoiceId, int flag, Object newInfo) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc != null && rc.updateEquipmentInvoice(invoiceId, flag, newInfo))
			return new ResortDBSupport().putRentalCenter(rc);
		else 
			return false;
	}

	@Override
	public boolean createRentalReservation(String rId, String rentalId, String equipId,
			Customer customer, DateTime start, DateTime end) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc != null && rc.createRentalReservation(rentalId, equipId, customer, start, end))
			return (new ResortDBSupport().putRentalCenter(rc));
		else
			return false;
	}
	
	@Override
	public boolean updateRentalReservation(String rId, String reservationId, int flag, Object newInfo) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rId);
		if(rc != null && rc.updateRentalReservation(reservationId, flag, newInfo))
			return new ResortDBSupport().putRentalCenter(rc);
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
	public boolean createRoomInvoice(String hid, int rmid, String iid, String notes) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		
		if(h.createRoomInvoice(hid, rmid, iid, notes) == false)
			return false;
		
		return(new ResortDBSupport().putHotel(h));
	}

	@Override
	public boolean createRoomReservation(String rrid, String hid, DateTime start, DateTime end, Customer cust, Attribute attr) {
		
		Hotel h = new ResortDBSupport().getHotel(hid);
		
		if(h.createRoomReservation(rrid, hid, start, end, cust, attr) == false)
			return false;
		
		return(new ResortDBSupport().putHotel(h));
	}
	
	@Override
	public boolean updateRoomReservation(String hId, String reservationId, int flag, Object newInfo) {
		
		Hotel h = new ResortDBSupport().getHotel(hId);
		if(h != null && h.updateRoomReservation(reservationId, flag, newInfo)) //TODO
			return true;
		else
			return false;
	}


	@Override
	public boolean updateEquipment(String rid, String eid, int flag, Object u) {
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		if(rc != null && rc.updateEquipment(eid, flag, u)) {
			return new ResortDBSupport().putRentalCenter(rc);
		}
		else 
			return false;
	}

	@Override
	public boolean updateRentalCenter(String rid, int flag, Object u) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		if(rc != null && rc.updateRentalCenter(flag, u)) {
			return new ResortDBSupport().putRentalCenter(rc);
		}
		else 
			return false;
	}

	@Override
	public boolean checkOutEquipment(String rid, String eid, String rentalId) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		if(rc != null && rc.checkOutEquipment(eid, rentalId)) {
			return new ResortDBSupport().putRentalCenter(rc);
		}
		else 
			return false;
	}

	@Override
	public boolean checkInEquipment(String rid, String eid, String rentalId) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		if(rc != null && rc.checkInEquipment(eid, rentalId)) {
			return new ResortDBSupport().putRentalCenter(rc);
		}
		else 
			return false;
	}
}
