package edu.iastate.cs362.Resort;

public class Resort implements ResortInterface {

	@Override
	public boolean createRentalCenter(String rid, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createHotel(String hid, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEquipment(String rid, String eid, String equipType,
			double cost, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEquipInvoice(String rid, String eid, String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRentalReservation(String rid, String eid,
			String cname, Date start, Date end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRoom(int beds, int baths, String desc, int rmid) {
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
			Customer cust, AttributeList attr) {
		// TODO Auto-generated method stub
		return false;
	}

}
