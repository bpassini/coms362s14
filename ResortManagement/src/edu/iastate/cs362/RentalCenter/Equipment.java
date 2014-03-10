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
		
	}
	
	//TODO add getter and setter methods
	
}
