import java.util.concurrent.Semaphore;

//DressingRooms will be a class, and there will only be one instance of DressingRooms.
//
//    The default constructor will use three rooms as the default.
//    The constructor takes a parameter that sets the number of rooms available.
//    Use a semaphore object to control access to the rooms.
//    Supply a public RequestRoom() method that the customer will use to gain access.
//    A RequestRoom method waits for an available room.

public class DressingRooms {
	int totalDressingRooms = 3;
	private Semaphore availableDressingRooms = new Semaphore(totalDressingRooms);
	
	public DressingRooms(int roomsAvailable) {
		//Default Constructor
		//Required to use 3 rooms as the default
		//Required to take a parameter that will set the number of available rooms
		totalDressingRooms = roomsAvailable;
	}
	
	public void RequestRoom(Customer customer) {
		//Used by customer to gain entrance
		//Should wait for an available room
		try {
			System.out.println("Customer " + customer.CustomerNumber + " is requesting a room.");
			availableDressingRooms.acquire();
			System.out.println("Customer " + customer.CustomerNumber + " is now entering the changing room.");
			System.out.println("Customer " + customer.CustomerNumber + " is bringing in " + customer.ClothingItems + " pieces of clothing.");
			UseDressingRoom(customer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UseDressingRoom(Customer customer) {
		//This method runs through the customer "using" the dressing room.
		//The Thread.sleep function uses milliseconds so 1000 = 1 second; therefore a full minute would be 60000!
		try {
			System.out.println(customer.CustomerNumber + " is beginning to try on clothing. This will take " + customer.totalNecessaryTimeInBooth/60 + " minutes.");
			Thread.sleep(customer.totalNecessaryTimeInBooth);
			ReleaseRoom(customer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ReleaseRoom(Customer customer) {
		System.out.println(customer.CustomerNumber + " just finished up! They are leaving the room.");
		availableDressingRooms.release();
		System.out.println(availableDressingRooms.availablePermits() + " dressing rooms are currently available.");
		
	}
		
}
