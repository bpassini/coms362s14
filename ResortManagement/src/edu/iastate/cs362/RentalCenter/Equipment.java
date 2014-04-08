package edu.iastate.cs362.RentalCenter;

/**
 *  Represents a piece of equipment the Resort may store in it's Rental Center and rent to customers.
 *  
 * @author Cameron Johnston
 *
 */
public class Equipment implements EquipmentInterface {
	
	/**
	 * The id of this piece of equipment.
	 */
	private String equipId;
	/**
	 * The type of this equipment.
	 */
	private String equipType;
	/**
	 * The rental cost of this piece of equipment. 
	 */
	private double cost;
	
	/**
	 * The description of this piece of equipment.
	 */
	private String description;
	
	/**
	 * The status of this piece of equipment, whether it is checkedIn to the rental center
	 * or checked out. 
	 */
	private boolean checkedIn;
	
	/**
	 * Creates an equipment object. 
	 * @param equipId - The id of this piece of equipment.
	 * @param equipType - The type of this equipment.
	 * @param cost - The rental cost of this piece of equipment.
	 * @param description - The description of this piece of equipment.
	 */
	public Equipment(String equipId, String equipType, double cost, String description) {
		this.equipId = equipId;
		this.equipType = equipType;
		this.cost = cost;
		this.description = description;
		this.checkedIn = true;	
	}
	
	/**
	 * Gets the Equipment id
	 * @return the id of the Equipment
	 */
	public String getEquipId() {
		return equipId;
	}
	
	/**
	 * Gets the Equipment type
	 * @return the type of the equipment
	 */
	public String getEquipType() {
		return equipType;
	}
	
	/**
	 * Gets the Equipment cost
	 * @return the cost of the equipment
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Gets the Equipment description
	 * @return the description of the equipment
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Get the Equipment status, whether it is checkedIn or not
	 * @return true if checkedIn, false if checkedOut
	 */
	public boolean getStatus() {
		return checkedIn;
	}

	@Override
	public boolean updateEquipment(int flag, Object u) {
		
		if(u instanceof String) {
			if(flag == UPDATE_TYPE) 
				equipType = (String) u;
			else if(flag == UPDATE_DESCRIPTION)
				description = (String) u;
		}
		else if(u != null && u.getClass() == double.class && flag == UPDATE_COST) 
			cost = (double) u;
		else 
			return false;
	
		return true;
	}

	@Override
	public boolean checkOutEquipment() {
		this.checkedIn = false;
		return true;
	}

	@Override
	public boolean checkInEquipment() {
		this.checkedIn = true;
		return true;
	}
	
}
