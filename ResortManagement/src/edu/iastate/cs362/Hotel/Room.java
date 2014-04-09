package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

/**
 * Represents a hotel room
 * 
 * @author Mike Pruszinske
 *
 */
public class Room implements RoomInterface {
	
	/**
	 * Hotel room ID
	 */
	private int rmid;
	
	/**
	 * Attribute object (containing ArrayList<String> beds and int occupancy)
	 */
	private Attribute attr;
	
	/**
	 * Description of room
	 */
	private String desc;
	
	/**
	 * The status of this room, true if checked out, false if available
	 */
	private boolean checkedOut;
	
	
	/**
	 * Creates a new hotel room according to the given parameters
	 * 
	 * @param rmid - Room ID
	 * @param attr - Attribute object containing room attributes
	 * @param desc - Description of room
	 */
	public Room(int rmid, Attribute attr, String desc) {
		
		this.rmid = rmid;
		this.attr = attr;
		this.desc = desc;
	}
	
	public int getRoomID() {
		return rmid;
	}
	
	public void setRoomID(int rmid) {
		this.rmid = rmid;
	}
	
	public Attribute getAttribute() {
		return attr;
	}
	
	public void setAttribute(Attribute attr) {
		this.attr = attr;
	}
	
	public int getOccupancy() {
		return attr.occupancy;
	}
	
	public void setOccupancy(int occupancy) {
		this.attr.occupancy = occupancy;
	}
	
	public ArrayList<String> getBeds() {
		return attr.beds;
	}
	
	public void setBeds(ArrayList<String> beds) {
		this.attr.beds = beds;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public void setDescription(String desc) {
		this.desc = desc;
	}
	
	public boolean setCheckedOut() {
		this.checkedOut = true;
		return true;
	}
	
	public boolean setAvailable()	{
		this.checkedOut = false;
		return true;
	}
	
	public boolean getStatus()	{
		return checkedOut;
	}
	
}
