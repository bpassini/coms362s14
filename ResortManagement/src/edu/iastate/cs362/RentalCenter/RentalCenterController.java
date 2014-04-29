package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Resort.Resort;
/**
 * Controller class dealing with RentalCenter.
 * @author Cameron Johnston
 * @author Bryan Passini
 * 
 */
public class RentalCenterController implements RentalCenterControllerInterface {

	@Override
	public boolean createRentalCenter(String rId, String name) {
		return (new Resort().createRentalCenter(rId, name));
	}

	@Override
	public boolean addEquipment(String rId, String equipId, String equipType,
			double cost, String description, boolean checkedIn) {
		
		return (new Resort().addEquipment(rId, equipId, equipType, cost, description, checkedIn));
	}

	@Override
	public boolean createEquipInvoice(String rId, String invoiceId, String equipId, String msg) {
		return (new Resort().createEquipInvoice(rId, invoiceId, equipId, msg));
	}

	@Override
	public boolean createRentalReservation(String rId, String rentalId, String equipId,
			Customer customer, String start, String end) {
		
		try {
			DateTimeFormatter df =  DateTimeFormat.forPattern("MM/dd/yyyy HH::mm");
			DateTime startDate = df.parseDateTime(start);
			DateTime endDate = df.parseDateTime(end);
			return (new Resort().createRentalReservation(rId, rentalId, equipId, customer, startDate, endDate));
		}
		catch(IllegalArgumentException iae) {
			return false;
		}
	}
	
	@Override
	public boolean updateRentalReservation(String rcId, String reservationId, int flag, Object newInfo) {
		return new Resort().updateRentalReservation(rcId, reservationId, flag, newInfo);
	}

	@Override
	public boolean updateEquipmentInvoice(String rId, String invoiceId, int flag, Object newInfo) {
		return new Resort().updateEquipmentInvoice(rId, invoiceId, flag, newInfo);
	}

	@Override
	public boolean updateEquipment(String rid, String eid, int flag, Object u) {
		return new Resort().updateEquipment(rid, eid, flag, u);
	}

	@Override
	public boolean updateRentalCenter(String rid, int flag, Object u) {
		return new Resort().updateRentalCenter(rid, flag, u);
	}

	@Override
	public boolean checkOutEquipment(String rid, String eid, String rentalId) {
		return new Resort().checkOutEquipment(rid, eid, rentalId);
	}

	@Override
	public boolean checkInEquipment(String rid, String eid, String rentalId) {
		return new Resort().checkInEquipment(rid, eid, rentalId);
	}
}
