package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

public interface RentalCenterControllerInterface {
	boolean createRentalCenter(String rid, String name);
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String rid, String eid, String msg);
	boolean createRentalReservation(String rid, String eid, String cname, DateTime start, DateTime end);
}
