package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;

public interface RentalCenterInterface {
	boolean addEquipment(String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String eid, String msg);
	boolean createRentalReservation(String eid, String cname, DateTime start, DateTime end);
}
