/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 2/9/15
 * Homework 2
 * Minivan Class
 */
package edu.uic.cs342.Jzhou46;

public class Minivan extends Node{//Minivan is a subclass of Node
	//unique field with defaulted values
	private int length = 200;
	private int width = 80;
	
	//Constructor with arguments
	public Minivan(String Make, String Model, int Year, String Status, int Id, int dailyCost, int length, int width, String kind){
		super(Make, Model, Year, Status, Id, dailyCost, kind);
		this.length = length;
		this.width = width;
	}
	
	public Minivan(){//Constructor with no arguments
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}//End of class
