//    Each scenario will record a start time and an end time.
//    The elapsed time will be calculated from those variables.
//    Calculate the number of customers.
//    Calculate the average number of items.
//    Calculate the average usage time of the room.
//    Calculate the time spent waiting for a room.

public class RunScenario {

	public static void main(String[] args) {
		Scenario testOne = new Scenario(3, 20, 0);
		System.out.println("Test one had 3 rooms, 20 guests and used a random amount of clothing.");
		System.out.println("The totals:");
		System.out.println("Total runtime (in minutes) " + (testOne.totalTime) + ".");
		System.out.println("Total amount of items " + testOne.totalNumberOfItems + ".");
		System.out.println("Total minutes spent in the dressing room " + testOne.totalUsageTime + ".");
		System.out.println("Total minutes spent waiting on a dressing room " + testOne.totalTimeSpentWaiting + ".");
		System.out.println("---------------------------------------");
		System.out.println("Average amount of items " + (testOne.totalNumberOfItems / testOne.numberOfCustomers) + ".");
		System.out.println("Average minutes in the dressing room " + (testOne.totalUsageTime / testOne.numberOfCustomers) + ".");
		System.out.println("Average minutes waiting on a dressing room " + (testOne.totalTimeSpentWaiting / testOne.numberOfCustomers) + ".");
		
		Scenario testTwo = new Scenario(2, 20, 0);
		System.out.println("Test one had 3 rooms, 20 guests and used a random amount of clothing.");
		System.out.println("The totals:");
		System.out.println("Total runtime (in minutes) " + (testTwo.totalTime) + ".");
		System.out.println("Total amount of items " + testTwo.totalNumberOfItems + ".");
		System.out.println("Total minutes spent in the dressing room " + testTwo.totalUsageTime + ".");
		System.out.println("Total minutes spent waiting on a dressing room " + testTwo.totalTimeSpentWaiting + ".");
		System.out.println("---------------------------------------");
		System.out.println("Average amount of items " + (testTwo.totalNumberOfItems / testTwo.numberOfCustomers) + ".");
		System.out.println("Average minutes in the dressing room " + (testTwo.totalUsageTime / testTwo.numberOfCustomers) + ".");
		System.out.println("Average minutes waiting on a dressing room " + (testTwo.totalTimeSpentWaiting / testTwo.numberOfCustomers) + ".");
		
		Scenario testThree = new Scenario(4, 20, 0);
		System.out.println("Test one had 3 rooms, 20 guests and used a random amount of clothing.");
		System.out.println("The totals:");
		System.out.println("Total runtime (in minutes) " + (testThree.totalTime) + ".");
		System.out.println("Total amount of items " + testThree.totalNumberOfItems + ".");
		System.out.println("Total minutes spent in the dressing room " + testThree.totalUsageTime + ".");
		System.out.println("Total minutes spent waiting on a dressing room " + testThree.totalTimeSpentWaiting + ".");
		System.out.println("---------------------------------------");
		System.out.println("Average amount of items " + (testThree.totalNumberOfItems / testThree.numberOfCustomers) + ".");
		System.out.println("Average minutes in the dressing room " + (testThree.totalUsageTime / testThree.numberOfCustomers) + ".");
		System.out.println("Average minutes waiting on a dressing room " + (testThree.totalTimeSpentWaiting / testThree.numberOfCustomers) + ".");
	}

}
