package edu.iastate.cs362.RentalCenter;

public interface RentalCenterDBSupportInterface {
	boolean putInvoice(String rId, EquipmentInvoice i);
	boolean putEquipment(String rId, Equipment e);
	boolean putReservation(String rId, RentalReservation r);
}
