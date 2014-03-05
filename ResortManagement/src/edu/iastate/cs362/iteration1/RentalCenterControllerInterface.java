package edu.iastate.cs362.iteration1;

public interface RentalCenterControllerInterface {
	boolean createRentalCenter(String rid, String name);
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String rid, String eid, String msg);
	boolean createRentalReservation(String rid, String eid, String cname, String startDate, String endDate);
}
