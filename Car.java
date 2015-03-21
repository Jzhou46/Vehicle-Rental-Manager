/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 2/9/15
 * Homework 2
 * Car Class
 */
package edu.uic.cs342.Jzhou46;

public class Car extends Node{//Car is a subclass of Node
	
	private String bodyType = "sedan";//unique field with defaulted value

	
	//Constructor with arguments
	public Car(String Make, String Model, int Year, String Status, int Id, int dailyCost, String bodyType, String kind){
		super(Make, Model, Year, Status, Id, dailyCost, kind);
		this.bodyType = bodyType;
	}
	
	public Car(){//Constructor with no arguments including unique fields
		super();
	}

	//Setters and Getters for all the fields
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

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
}//End of class
