//Customer will be implemented as a thread.
//
//    Allow for a parameter named NumberOfItems .
//    ClothingItems = 0 will indicate the use of a random number.
//    ClothingItems = 1 – 20 will allow for load testing by forcing a specific number of items.
//    The store policy is a maximum of six items, but this may be modified during a test.

public class Customer {
	int totalCount = 0;
	int CustomerNumber;
	int ClothingItems;
	int totalNecessaryTimeInBooth;
	long startTime;
	long endTime;
	long waitTime;
	
	public Customer(int NumberOfItems) {
		int MaxClothing = 6;
		totalCount++;
		this.CustomerNumber = totalCount;
		//If the NumberOfItems is 0, it's a random number between the minimum (1) and max
		if (NumberOfItems == 0) {
			this.ClothingItems = (int)((Math.random()*MaxClothing)+1);
		} else {
			this.ClothingItems = NumberOfItems;
		}
		//Iterates over the amount of clothing to set the wait time
		//Actual time should be 1-3 minutes per piece of clothing. Instead of waiting we'll make those milliseconds.
		//Otherwise, they'd naturally need to be *60
		for (int i = 0; i < this.ClothingItems; i++) {
			this.totalNecessaryTimeInBooth += (int)((Math.random()*3)+1);
		}
		System.out.println(CustomerNumber + " has " + this.ClothingItems + " that will require " + this.totalNecessaryTimeInBooth + " minutes in the changing room.");
	}
	
	public void startTime() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void endTime() {
		this.endTime = System.currentTimeMillis();
		setWaitTime(this.startTime, this.endTime);
	}
	
	public void setWaitTime(long startTime, long endTime) {
		this.waitTime = endTime - startTime;
		System.out.println("Total wait time in minutes " + this.waitTime/60);
	}
	
}
