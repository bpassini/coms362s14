package edu.iastate.cs362.iteration1;

public interface RentalCenterDBSupportInterface {
	boolean putInvoice(EquipmentInvoice i);
	boolean putEquipment(Equipment e);
	boolean putReservation(RentalReservation r);
}
