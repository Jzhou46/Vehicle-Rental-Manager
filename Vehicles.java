/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 2/9/15
 * Homework 2
 * Vehicles Class
 */

package edu.uic.cs342.Jzhou46;

public abstract class Vehicles {//This is an abstract class that provides the similar fields for all vehicles
	//Fields with defaulted values
	protected String Make = "Toyota"; 
	protected String Model = "Camry";
	protected int Year = 2008;
	protected String Status = "Available";
	protected int Id = 1;
	protected int dailyCost = 10;
	protected String kind = "car";
	
	//Constructor with arguments
	public Vehicles(String Make, String Model, int Year, String Status, int Id, int dailyCost, String kind) {
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
		this.Status = Status;
		this.Id = Id;
		this.dailyCost = dailyCost;
		this.kind = kind;
	}
	//Constructor with out arguments
	public Vehicles(){
	}
}//End of class
