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
	 * Max occupancy of room
	 */
	private int occup;
	
	/**
	 * ArrayList of beds contained in the room, size = number of beds
	 */
	private ArrayList<String> beds;
	
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
	public Room(int rmid, int occup, ArrayList<String> beds, String desc) {
		
		this.rmid = rmid;
		this.occup = occup;
		this.beds = beds;
		this.desc = desc;
	}
	
	public int getRoomID() {
		return rmid;
	}
	
	public void setRoomID(int rmid) {
		this.rmid = rmid;
	}
	
	public int getOccupancy() {
		return occup;
	}
	
	public void setOccupancy(int occup) {
		this.occup = occup;
	}
	
	public ArrayList<String> getBeds() {
		return beds;
	}
	
	public void setBeds(ArrayList<String> beds) {
		this.beds = beds;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public void setDescription(String desc) {
		this.desc = desc;
	}
	
	@Override
	public boolean setCheckedOut() {
		this.checkedOut = true;
		return true;
	}
	
	@Override
	public boolean setAvailable()	{
		this.checkedOut = false;
		return true;
	}
	
	public boolean getStatus()	{
		return checkedOut;
	}
	
}
