/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 2/9/15
 * Homework 2
 * Client Class
 */
package edu.uic.cs342.Jzhou46;
import java.util.Scanner;

//This class is for testing purposes
public class Client extends LinkedList{
	//Method to display what the commands are 
	public static void menu(){
		System.out.println("The commands for this program are: ");
		System.out.println("v—Add a new vehicle to the system"); 
		System.out.println("c—Change vehicle status"); 
		System.out.println("d—Resets the linked list of vehicles to be an empty list"); 
		System.out.println("l—Lists all the vehicles"); 
		System.out.println("a—Lists all the vehicles whose status is available for rental"); 
		System.out.println("s—The vehicles in the original linked list are sorted alphabetically by the make and model of the vehicle"); 
		System.out.println("q—Quits the VRM"); 
		System.out.println("?—Displays the commands");
	}
	
	public static void main(String[] args){
		LinkedList vehicles = new LinkedList();//Create a new linked list called vehicles
		Scanner input = new Scanner(System.in);//Declare a new Scanner for input called input
		int Id = 0;
		System.out.println("Welcome to the VRM\n");//Now prompt the user for commands		
		menu();//Display commands
		while(true){
			System.out.print("\nPlease enter a command: ");			
			//Get the character input
			char c = input.next(".").charAt(0);
			if(c == 'v'){//If character is v
				System.out.println("\nADDING NEW VEHICLE TO THE SYSTEM:\n");
				//Prompt the user for values of all the fields of the vehicle to be added
				System.out.print("Please enter a value for Make(Ex: Honda, Toyota, Mazda, Nissan, etc): ");
				String Make = input.next();
				System.out.print("Please enter a value for Model(Ex: Civic, Camry, Miata, Maxima, etc): ");
				String Model = input.next();
				System.out.print("Please enter a value for Year(Ex: 2015): ");
				int Year = input.nextInt();
				System.out.print("Please enter a value for Status(Ex: available or rented): ");
				String Status = input.next();
				System.out.print("Please enter a value for Daily Cost(Ex: 50): ");
				int dailyCost = input.nextInt();
				System.out.print("Please specify the kind of vehicle(Car, Truck, or Minivan): ");
				String kind = input.next();
				if(kind.equals("Car") || kind.equals("car")){//If vehicle is specified as a car
					System.out.print("Please enter a value for Body Type(Ex: sedan, hatchback, station wagon, convertible, coupe, etc): ");
					String bodyType = input.next();
					Id++;
					Node car = new Car(Make, Model, Year, Status, Id, dailyCost, bodyType, kind);//Create car
					vehicles.insert(car);//Insert car into list
					System.out.println("New car ID is: " + Id);
				}
				else if(kind.equals("Truck") || kind.equals("truck")){//If vehicle is specified as a truck
					System.out.print("Please enter a value for Max Cargo(Ex: 500.00): ");
					float maxCargo = input.nextFloat();
					Id++;
					Node truck = new Truck(Make, Model, Year, Status, Id, dailyCost, maxCargo, kind);//Create truck
					vehicles.insert(truck);//Insert truck into list
					System.out.println("New car ID is: " + Id);
				}
				else if(kind.equals("Minivan") || kind.equals("minivan")){//If vehicle is specified as a minivan
					System.out.print("Please enter a value for the length(Ex: 200): ");
					int length = input.nextInt();
					System.out.print("Please enter a value for the width(Ex: 80): ");
					int width = input.nextInt();
					Id++;
					Node minivan = new Minivan(Make, Model, Year, Status, Id, dailyCost, length, width, kind);//Create minivan
					vehicles.insert(minivan);//Insert minivan into list
					System.out.println("New car ID is: " + Id);
				}
				else{
					System.out.println("Invalid Input. Please try again.");
				}
			}//End of if command = v
			else if(c == 'c'){//If character is c
				System.out.println("\nCHANGING VEHICLE STATUS:\n");
				System.out.print("Please enter a ID value for the vehicle status you want to change: ");
				int ID = input.nextInt();
				if(vehicles.contains(ID) == false){
					System.out.println("Invalid ID value. Please try again");
				}
				else{
					System.out.print("Please enter a new status: ");
					String Status = input.next();
					vehicles.changeStatus(ID, Status);
				}
			}//End of if command = c
			else if(c == 'd'){//If character is d
				System.out.println("\nLIST OF VEHICLES HAVE RESET TO AN EMPTY LIST");
				vehicles.removeAll();
				Id = 0; 
			}
			else if(c == 'l'){//If character is l
				System.out.println("\nLISTING OF ALL VEHICLES:");
				vehicles.print(); 
			}
			else if(c == 'a'){//If character is a
				System.out.println("\nLISTING OF ALL VEHICLES THAT ARE AVAILIABLE FOR RENTAL:");
				vehicles.printAvailable(); 
			}
			else if(c == 's'){//If character is s
				System.out.println("\nLIST OF VEHICLES HAVE BEEN SORTED IN ALPHABETICALLY ORDER");
				boolean isSorted = false;
				while(isSorted == false){//While the list is not fully sorted
					vehicles = vehicles.sort();//Go down the list and swap the nodes that are out of place
					isSorted = vehicles.checkSortness();//Check if the list is still unsorted
				}
			}
			else if(c == 'q'){//If character is q
				System.out.println("\nVRM HAS BEEN TERMINATED"); 
				return;
			}
			else if(c == '?'){//If character is ?
				menu();
			}
			else{
				System.out.println("\nYou entered an invalid command. Please try again."); 	
			}
		}//End of while loop	
	}//End of main
}//End of class
