package edu.iastate.cs362.RentalCenter;

public interface RentalCenterInterface {
	boolean addEquipment(String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String eid, String msg);
	boolean createRentalReservation(String eid, String cname, Date start, Date end);
}
