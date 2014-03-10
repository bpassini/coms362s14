package edu.iastate.cs362.Resort;


import edu.iastate.cs362.RentalCenter.*;
import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;


public class Resort implements ResortInterface {

	@Override
	public boolean createRentalCenter(String rid, String name) {
		return new ResortDBSupport().putRentalCenter(new RentalCenter(rid, name));
	}

	@Override
	public boolean createHotel(String hid, String name) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean createRentalReservation(String rid, String eid,
			String cname, Date start, Date end) {
		
		RentalCenter rc = new ResortDBSupport().getRentalCenter(rid);
		return rc.createRentalReservation(eid, cname, start, end);
	}

	@Override
	public boolean addRoom(int beds, int occup, String desc, int rmid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRoomInvoice(int rmid, String notes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRoomReservation(String hotel, Date start, Date end,
			Customer cust, Attribute attr) {
		// TODO Auto-generated method stub
		return false;
	}

}
