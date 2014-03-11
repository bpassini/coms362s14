package edu.iastate.cs362.RentalCenter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Resort.Resort;
/**
 * Controller class dealing with RentalCenter.
 * @author Cameron Johnston
 * 
 */
public class RentalCenterController implements RentalCenterControllerInterface {

	@Override
	public boolean createRentalCenter(String rId, String name) {
		return (new Resort().createRentalCenter(rId, name));
	}

	@Override
	public boolean addEquipment(String rId, String equipId, String equipType,
			double cost, String description) {
		
		return (new Resort().addEquipment(rId, equipId, equipType, cost, description));
	}

	@Override
	public boolean createEquipInvoice(String rId, String invoiceId, String equipId, String msg) {
		return (new Resort().createEquipInvoice(rId, invoiceId, equipId, msg));
	}

	@Override
	public boolean createRentalReservation(String rId, String rentalId, String equipId,
			Customer customer, String start, String end) {
		
		try {
			DateTimeFormatter df =  DateTimeFormat.forPattern("dd/MM/yyyy HH::mm");
			DateTime startDate = df.parseDateTime(start);
			DateTime endDate = df.parseDateTime(end);
			return (new Resort().createRentalReservation(rId, rentalId, equipId, customer, startDate, endDate));
		}
		catch(IllegalArgumentException iae) {
			return false;
		}
	}

}
