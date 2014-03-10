package edu.iastate.cs362.Hotel;

public class RoomInvoice implements RoomInvoiceInterface {
	
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
	 * @param rmid - Room ID
	 * @param notes - Description of the issue or notes
	 */
	public RoomInvoice(int rmid, String notes) {
		
		this.rmid = rmid;
		this.notes = notes;
	}

}
