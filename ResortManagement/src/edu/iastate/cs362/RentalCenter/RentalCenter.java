package edu.iastate.cs362.RentalCenter;

import org.joda.time.*;

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
		
		Equipment e = new Equipment(eid, equipType, cost, description);
		return (new RentalCenterDBSupport().putEquipment(e));
	}

	@Override
	public boolean createEquipInvoice(String eid, String msg) {
		
		EquipmentInvoice i = new EquipmentInvoice(eid, msg);
		return (new RentalCenterDBSupport().putInvoice(i));
	}

	@Override
	public boolean createRentalReservation(String eid, String cname,
			DateTime start, DateTime end) {
		
		RentalReservation r = new RentalReservation(eid, cname, start, end);
		return (new RentalCenterDBSupport().putReservation(r));
	}
	
	//TODO add getter and setter methods

}
