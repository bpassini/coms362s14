package edu.iastate.cs362.RentalCenter;

public interface RentalCenterDBSupportInterface {
	boolean putInvoice(EquipmentInvoice i);
	boolean putEquipment(Equipment e);
	boolean putReservation(RentalReservation r);
}
