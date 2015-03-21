
//NOTE: THIS CLASS WAS COMPLETELY CREATED BY PROF. BUY(WITH THE EXCEPTION OF THE METHOD(S) THAT I HAVE CREATED) AND HAD GIVEN ME PERMISSION TO USE IT.

package edu.uic.cs342.Jzhou46;

/***
 * Author: Ugo Buy
 * Content: A simple LinkedList implementation to illustrate OO paradigm.
 * Date: July 9, 2014
 * Modification history:
 * 
 * 		July 10 -- Ugo Buy -- Added remove() method and static variable tally.
 * 		July 11 -- Ugo Buy -- Added union() and print() methods
 * 		August 12 -- Ugo Buy -- Fixed bugs in remove()
 * 
 */


/**
 * 
 * @author Ugo Buy
 *
 *  Class LinkedList implements a standard linked list for the purpose of illustrating
 *  features of classes.  This version uses a Node class for nodes storing integer 
 *  numbers.  LinkedList uses two Node references to the first and the last node in
 *  the list.  Insertions are always performed in the back of the queue.  Removal of a
 *  specific element is also supported, along with set union.  Static variable tally
 *  tracks the number LinkedList instances created thus far. 
 */
public class LinkedList extends Vehicles{
	
	/** No-arg constructor just increments total number of instances created
	 * 
	 */
	public LinkedList() {
		tally++;
	}
	
	/** Integer argument constructor initializes instance with a single Node
	 * 
	 * @param int i:  The first element to be inserted in list
	 */
	
	public LinkedList(int x) {
		head = tail = new Node(x) ;
		size = 1 ;
		tally++ ;
	}
	
	/** This method is called before a LinkedList is destroyed by the garbage collector.
	 * 
	 */
	public void finalize() {
		tally--;
	}
	
	//This method was originally created by Prof. Buy, but I have modified it to take in Nodes
	public LinkedList insert(Node x) {
		if (head == null) {//If list is empty		
			head = tail = x;  
		}
		else {//Not empty
			tail.next(x) ;//Put it at the end of the list
			tail = tail.next() ;//Reset tail
		}
		size++;
		return this ;
	}
	/** The membership test for a LinkedList
	 * 
	 * @param int x An integer
	 * @return boolean indicating whether the receiver (a LinkedList instance) 
	 *         contains input x.
	 */
	
	public boolean contains(int x) {
		
		for (Node n = this.head; n != null; n = n.next()) {
			if (n.Id == x) { return true ; }
		}
		
		return false;
	}
	
	//Method to change the Status of a given vehicle by it's ID
	public void changeStatus(int x, String status){
		for (Node n = this.head; n != null; n = n.next()) {//Traverse down the list
			if(n.Id == x){//If the ID of the vehicle matches the ID of what that user entered
				n.setStatus(status);//Change it to the ID that the user entered
			}
		}	
	}
	
	/** The method for removing a node from a LinkedList instance
	 * 
	 * @param int x An integer denoting the element whose node must be removed from the 
	 *              receiver.
	 * @return boolean indicating whether the removal was successful or not.
	 */
	
	public boolean remove(int x) {		
		// Receiver is empty?  Return false
		if (head == null) return false;
		
		// Element to be removed is first in list?  Remove first node; update 
		// fields head, tail (if this was the only node), and size; and return.
		if (head.element() == x) {
			head = head.next() ;
			if (head == null) {
				tail = null;
			}
			size--;
			return true;
		}		
		// Otherwise, scan list for element to be removed.  When found, remove and
		// return true
		for (Node cursor = head.next(), previous = head;  cursor != null; 
				previous = cursor, cursor = cursor.next()) {
			if (cursor.element() == x) {
				if (cursor == tail) {
					tail = previous ;
				}
				previous.next(cursor.next()) ;
				size--;
				return true ;
			}			
		}	
		// If you got here, you must return false
		return false;
	}
	
	//Method to check if a list if sorted
	public boolean checkSortness(){
		for (Node cursor = head.next(), previous = head;  cursor != null; 
				previous = cursor, cursor = cursor.next()) {	
			if(cursor.Make.compareTo(previous.Make) < 0){//If the next node's Make is greater in order than the current node's Make
				return false;
			}
			else if(cursor.Make.compareTo(previous.Make) == 0){//If the next node's Make is equal in order than the current node's Make
				if(cursor.Model.compareTo(previous.Model) < 0){//If the next node's Model is greater in order than the current node's Model
					return false;
				}
			}	
		}//End of for loop
		return true;
	}
	
	//Method to sort the list alphabetically 
	public LinkedList sort() {
		LinkedList sortList = new LinkedList();//Create new linked list		
		if (head == null){//If list is empty 
			System.out.println("List is empty.");
			return this;
		}	
		if (head.next() == null) {//If list has only one node
			return this;
		}
		//Otherwise list has at least 2 elements 
		for (Node cursor = head.next(), previous = head;  cursor != null; 
				previous = cursor, cursor = cursor.next()) {		
			Node temp;
			if(cursor.Make.compareTo(previous.Make) < 0){//If the next node's Make is less in order than the current node's Make
				if (cursor == tail) {//If the next node is the last node
					//Perform swap operation
					previous.next(cursor.next());
					cursor.next(previous);
					temp = cursor;
					cursor = previous;
					previous = temp;
					//add the nodes into new list
					sortList.insert(previous);
					sortList.insert(cursor);
				}			
				else {
					//Perform swap operation
					previous.next(cursor.next());
					cursor.next(previous);
					temp = cursor;
					cursor = previous;
					previous = temp;
					//add current node
					sortList.insert(previous);
				}
			}//End of outer if statement
			else if(cursor.Make.compareTo(previous.Make) == 0){//If the next node's Make is equal in order than the current node's Make
				if(cursor.Model.compareTo(previous.Model) < 0){//If the next node's Model is less in order than the current node's Model				    
					if (cursor == tail) {//If the next node is the last node
						//Perform swap operation
						previous.next(cursor.next());
						cursor.next(previous);
						temp = cursor;
						cursor = previous;
						previous = temp;
						//Add nodes into new list 
						sortList.insert(previous);
						sortList.insert(cursor);
					}
					else {
						//Perform swap operation
						previous.next(cursor.next());
						cursor.next(previous);
						temp = cursor;
						cursor = previous;
						previous = temp;
						//add current node into new list
						sortList.insert(previous);
					}
				}//End of if statement
				else{
					//add current node into new list
					sortList.insert(previous);
					if(cursor == tail){//If the next node is the last node
						sortList.insert(cursor);//add last node into new list
					}
				}
			}//End of else if
			else{
				//add current node into new list
				sortList.insert(previous);
				if(cursor == tail){//If the next node is the last node
					sortList.insert(cursor);//add last node into new list
				}
			}
					
		}//End of for loop
        return sortList;
	}
	
	//Method to empty the list
	public void removeAll() {
		// Receiver is empty?  Return false
		if (head == null) 
			return;
		Node curr; 
		while(head != null){
			curr = head.next();
			curr = null; 
			head = curr;
		}
		return;
	}

	
	/** This method prints the content of the receiver on the standard output stream.
	 * An appropriate message is output if the receiver has no nodes.  Otherwise, the
	 * integer number stored in each node is printed in the order of the nodes.
	 */
	public void print() {
		if (head == null) 
			System.out.print("Nothing to print here!\n");
		else {
			for (Node n = head; n != null; n = n.next()) {//Traverse down the list
				//Print out all the regular fields
				System.out.println("\nMake: " + n.Make);
				System.out.println("Model: " + n.Model);
				System.out.println("Year:" + n.Year);
				System.out.println("Status: " + n.Status);
				System.out.println("ID: " + n.Id);
				System.out.println("Daily Cost: " + n.dailyCost);
				if(n.kind.equals("Car") || n.kind.equals("car")){//Check if the kind of vehicle is a car
					//print out unique field
					System.out.println("Bodytype: " + ((Car)n).getBodyType());
					System.out.println("Kind: " + n.kind);
					
				}
				else if(n.kind.equals("Truck") || n.kind.equals("truck")){//Check if the kind of vehicle is a truck
					//print out unique field
					System.out.println("Max Cargo: " + ((Truck)n).getMaxCargo());
					System.out.println("Kind: " + n.kind);
					
				}
				else if(n.kind.equals("Minivan") || n.kind.equals("minivan")){//Check if the kind of vehicle is a minivan
					//print out unique fields
					System.out.println("Length: " + ((Minivan)n).getLength());
					System.out.println("Width: " + ((Minivan)n).getWidth());
					System.out.println("Kind: " + n.kind);
					
				}
			}//End of for loop
			System.out.print("\n");
		}//End of else
	}//End of print method
	
	public void printAvailable() {
		if (head == null) 
			System.out.print("Nothing to print here!\n");
		else {
			for (Node n = head; n != null; n = n.next()) {//Traverse down the list
				if(n.Status.equals("Available") || n.Status.equals("available")){//If the user enters a string that matches
					//Print all the regular fields
					System.out.println("\nMake: " + n.Make);
					System.out.println("Model: " + n.Model);
					System.out.println("Year:" + n.Year);
					System.out.println("Status: " + n.Status);
					System.out.println("ID: " + n.Id);
					System.out.println("Daily Cost: " + n.dailyCost);
					if(n.kind.equals("Car") || n.kind.equals("car")){//Check if the kind of vehicle is a car
						//print out unique field
						System.out.println("Bodytype: " + ((Car)n).getBodyType());
						System.out.println("Kind: " + n.kind);
						
					}
					else if(n.kind.equals("Truck") || n.kind.equals("truck")){//Check if the kind of vehicle is a truck
						//print out unique field
						System.out.println("Max Cargo: " + ((Truck)n).getMaxCargo());
						System.out.println("Kind: " + n.kind);
						
					}
					else if(n.kind.equals("Minivan") || n.kind.equals("minivan")){//Check if the kind of vehicle is a minivan
						//print out unique fields
						System.out.println("Length: " + ((Minivan)n).getLength());
						System.out.println("Width: " + ((Minivan)n).getWidth());
						System.out.println("Kind: " + n.kind);
						
					}
				}//End of if statement				
			}//End of for loop
			System.out.print("\n");
		 }//End of else statement
	}//End of printAvailable method
	
	/**
	 * print() will print the integer values contained in the receiver
	 * starting from the first node all the way to the last node.
	 * 
	 * @param String name -- The print name of this linked list 
	 */
	public void print(String name) {
		
		if (head == null) 
			System.out.format("List %s is empty!\n", name);
		else {
			System.out.format("List %s: ", name) ;
			for (Node n = head; n != null; n = n.next()) {
				System.out.format("%d ", n.element());				
			}
			System.out.print("\n");
		}
	}
	
	
	/** 
	 * Getter method for size field.
	 * @return int size
	 */
	public int size() {
		return size;
	}	

	/** 
	 * Getter method for head field.
	 * @return int size
	 */
	public Node head() {
		return head ;
	}
	
	/** The fields point to the head and tail Node objects of the list.
	 * A size field keeps track of the total size of the list.
	 */
	protected Node head = null ;
	protected Node tail = null ;
	protected int size = 0 ;
	
	/** returns the tally
	 * 
	 */
	public static int tally() {
		return tally;
	}
	
	/** 
	 * Static field to keep track of total number of instances of LinkedList created
	 * and not garbage collected yet.
	 */
	protected static int tally = 0;

}

