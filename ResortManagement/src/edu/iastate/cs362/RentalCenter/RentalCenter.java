package edu.iastate.cs362.RentalCenter;

public class RentalCenter implements RentalCenterInterface {
	
	private String id;
	private String name;
	
	public RentalCenter(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean addEquipment(String eid, String equipType, double cost,
			String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEquipInvoice(String eid, String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRentalReservation(String eid, String cname,
			Date start, Date end) {
		// TODO Auto-generated method stub
		return false;
	}

}
