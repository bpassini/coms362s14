package edu.iastate.cs362.RentalCenter;

/**
 * Interface for Equipment class
 * 
 * @author Cameron Johnston
 *
 */
public interface EquipmentInterface {
	boolean updateEquipment(EquipmentFlag flag, Object u);
	boolean checkOutEquipment();
	boolean checkInEquipment();
}