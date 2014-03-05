package edu.iastate.cs362.iteration1;

public interface RentalCenterInterface {
	boolean addEquipment(String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String eid, String msg);
	boolean createRentalReservation(String eid, String cname, String startDate, String endDate);
}
