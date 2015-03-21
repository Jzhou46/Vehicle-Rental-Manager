/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 2/9/15
 * Homework 2
 * Truck Class
 */
package edu.uic.cs342.Jzhou46;

public class Truck extends Node{//Truck is a subclass of Node
	private float maxCargo = 2;//unique field with defaulted value
	
	//Constructor with arguments
	public Truck(String Make, String Model, int Year, String Status, int Id, int dailyCost, float maxCargo, String kind){
		super(Make, Model, Year, Status, Id, dailyCost, kind);
		this.maxCargo = maxCargo;
	}
	
	public Truck(){//Constructor with no arguments
		super();
	}

	//Setters and Getters for all the fields including unique fields
	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}

	public float getMaxCargo() {
		return maxCargo;
	}

	public void setMaxCargo(float maxCargo) {
		this.maxCargo = maxCargo;
	}
}//End of class
