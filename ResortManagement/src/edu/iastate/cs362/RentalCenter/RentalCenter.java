package edu.iastate.cs362.RentalCenter;

import org.joda.time.*;
/**
 * Class representing a RentalCenter.  Our resort can own many different RentalCenters.
 * @author Cameron Johnston
 *
 */
public class RentalCenter implements RentalCenterInterface {
	
	/**
	 * The id for this Rental Center.
	 */
	private String rId;
	
	/**
	 *  The name of this Rental Center.
	 */
	private String name;
	
	/**
	 * Creates a new RentalCenter object.
	 * @param id - The id for this Rental Center.
	 * @param name - The name of this Rental Center.
	 */
	public RentalCenter(String rId, String name) {
		this.rId = rId;
		this.name = name;
	}

	@Override
	public boolean addEquipment(String eid, String equipType, double cost,
			String description) {
		
		Equipment e = new Equipment(eid, equipType, cost, description);
		return (new RentalCenterDBSupport().putEquipment(rId, e));
	}

	@Override
	public boolean createEquipInvoice(String invoiceId, String eid, String msg) {
		
		EquipmentInvoice i = new EquipmentInvoice(invoiceId, eid, msg);
		return (new RentalCenterDBSupport().putInvoice(rId, i));
	}

	@Override
	public boolean createRentalReservation(String rentalId, String eid, String cname,
			DateTime start, DateTime end) {
		
		RentalReservation r = new RentalReservation(eid, cname, start, end);
		return (new RentalCenterDBSupport().putReservation(rId, r));
	}
	
	//TODO add getter and setter methods

}
