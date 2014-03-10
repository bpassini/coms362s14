package edu.iastate.cs362.RentalCenter;

import edu.iastate.cs362.Resort.*;

public class RentalCenterController implements RentalCenterControllerInterface {

	@Override
	public boolean createRentalCenter(String rid, String name) {
		return (new Resort().createRentalCenter(rid, name));
	}

	@Override
	public boolean addEquipment(String rid, String eid, String equipType,
			double cost, String description) {
		
		return (new Resort().addEquipment(rid, eid, equipType, cost, description));
	}

	@Override
	public boolean createEquipInvoice(String rid, String eid, String msg) {
		return (new Resort().createEquipInvoice(rid, eid, msg));
	}

	@Override
	public boolean createRentalReservation(String rid, String eid,
			String cname, Date start, Date end) {
		
		return (new Resort().createRentalReservation(rid, eid, cname, start, end));
	}

}
