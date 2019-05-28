import java.awt.List;
import java.util.ArrayList;

//Scenario will be a class.
//
//    Create a constructor that accepts:
//        The number of rooms available.
//        The number of customers.
//    Create rooms as specified.
//    Create customers as specified

public class Scenario {
	int numberOfCustomers;
	int totalNumberOfItems = 0;
	int totalUsageTime = 0;
	int totalTimeSpentWaiting = 0;
	long startTime;
	long endTime;
	long totalTime;

	public Scenario(int roomsAvailable, int numberOfCustomers, int numberOfItems) {
		//Starts the timer
		this.startTime = System.currentTimeMillis();
		//Constructor that accepts number of available rooms and number of customers
		ArrayList<Customer> customerList = CreateCustomers(numberOfCustomers, numberOfItems);
		DressingRooms dressingRoom = CreateRoom(roomsAvailable);
		for (Customer customer : customerList) {
			customer.CustomerNumber++;
			this.numberOfCustomers++;
			customer.startTime();
			dressingRoom.RequestRoom(customer);
			customer.endTime();
			this.totalNumberOfItems += customer.ClothingItems;
			this.totalTimeSpentWaiting += customer.waitTime;
			this.totalUsageTime += customer.totalNecessaryTimeInBooth;
		}
		//Stops the timer to show total run time
		this.endTime = System.currentTimeMillis();
		this.totalTime = endTime - startTime;
	}
	
	public DressingRooms CreateRoom(int numberToCreate) {
		DressingRooms dressingRoom = new DressingRooms(numberToCreate);
		return dressingRoom;
	}
	
	public ArrayList<Customer> CreateCustomers(int numberToCreate, int numberOfItems) {
		//This will create an arraylist that will hold all the customer objects
		//This takes the parameter of number of items so we know how many to set the customer to have
		//As the Customer class will show, inputting a "0" will result in a random 1-6 number.
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		for (int i = 0; i < numberToCreate; i++) {
			customerList.add(new Customer(numberOfItems));
		}
		return customerList;
	}
	
}
