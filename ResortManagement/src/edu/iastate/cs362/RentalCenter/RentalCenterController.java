package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Resort.Resort;
/**
 * Controller class dealing with RentalCenter.
 * @author Cameron Johnston
 * 
 */
public class RentalCenterController implements RentalCenterControllerInterface {

	@Override
	public boolean createRentalCenter(String rid, String name) {
		return (new Resort().createRentalCenter(rid, name));
	}

	@Override
	public boolean addEquipment(String rid, String eid, String equipType,
			double cost, String description) {
		
		return (new Resort().addEquipment(rid, eid, equipType, cost, description));
	}

	@Override
	public boolean createEquipInvoice(String rid, String invoiceId, String eid, String msg) {
		return (new Resort().createEquipInvoice(rid, invoiceId, eid, msg));
	}

	@Override
	public boolean createRentalReservation(String rid, String rentalId, String eid,
			String cname, String start, String end) {
		
		DateTimeFormatter df =  DateTimeFormat.forPattern("dd/MM/yyyy HH::mm");
		DateTime startDate = df.parseDateTime(start);
		DateTime endDate = df.parseDateTime(end);
		return (new Resort().createRentalReservation(rid, rentalId, eid, cname, startDate, endDate));
	}

}
