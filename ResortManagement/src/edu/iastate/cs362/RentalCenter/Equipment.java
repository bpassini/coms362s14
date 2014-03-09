package edu.iastate.cs362.RentalCenter;

public class Equipment implements EquipmentInterface {
	
	private String id;
	private String equipType;
	private double cost;
	private String description;
	
	public Equipment(String id, String equipType, double cost, String description) {
		this.id = id;
		this.equipType = equipType;
		this.cost = cost;
		this.description = description;
		
	}
	
	//TODO add getter and setter methods
	
}
