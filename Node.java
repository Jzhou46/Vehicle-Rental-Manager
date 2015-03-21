
//NOTE: THIS CLASS WAS COMPLETELY CREATED BY PROF. BUY(WITH THE EXCEPTION OF THE METHOD(S) THAT I HAVE CREATED) AND HAD GIVEN ME PERMISSION TO USE IT.

package edu.uic.cs342.Jzhou46;

/** 
* 
* @author Ugo Buy
*
* This is a very simple node class for a single-linked list.  Each node stores an
* int.
*   
*/
public class Node extends Vehicles{
	
	/**
	 * Single argument constructor initializes new Node instance to store the value x
	 * passed as an argument.  No default constructor exists, so instance creation for 
	 * this class is always required to provide an integer value.
	 * 
	 * @param int x--The value to be stored in the initially created node.
	 */
	public Node(int x) {
		element = x;
		next = null;
	}
	public Node(String Make, String Model, int Year, String Status, int Id, int dailyCost, String kind){
		super(Make, Model, Year, Status, Id, dailyCost, kind); 
		next = null; 
		element = 0;
	}
	
	public Node(){
		super();
	}
	/** 
	 * Getter method for element field
	 * 
	 * @return int--The current value of element
	 */
	
	public int element() { return element ; }
	
	/**
	 * Getter method for next field
	 * 
	 * @return Node--The next Node in the chain, or null
	 * 
	 */
	public Node next() { return next ; }
	
	/**
	 * Setter method for element field
	 * 
	 * @param int newElement--New value of element field.
	 * 
	 */
	
	public void element(int newElement) {
		element = newElement;
	}
	
	
	/**
	 * Setter method for next field
	 * 
	 * @param Node newNext--New value for next field
	 * 
	 */
	public void next(Node newNext) {
		next = newNext ;
	}
	
	// Element field stores int value; next stores pointer to next node.
	private int element = 0 ;
	private Node next = null ;
	
	//Setter for the Status field
	public void setStatus(String status){
		this.Status = status;
	}

}
