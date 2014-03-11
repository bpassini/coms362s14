package edu.iastate.cs362.Hotel;

public class RoomInvoice implements RoomInvoiceInterface {
	
	/**
	 * Hotel ID
	 */
	String hid;
	
	/**
	 * Hotel room ID
	 */
	int rmid;
	
	/**
	 * Summary of issue & additional notes
	 */
	String notes;
	
	
	/**
	 * Creates a room invoice with the given parameters
	 * 
	 * @param hid - Hotel ID
	 * @param rmid - Room ID
	 * @param notes - Description of the issue or notes
	 */
	public RoomInvoice(String hid, int rmid, String notes) {
			
		this.hid = hid;
		this.rmid = rmid;
		this.notes = notes;
	}

}
