import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//prints stars at beginning output
	public static void printStarsAtBeginning() {

		System.out.println("******************************");
		System.out.println("****** S store ***************");
		System.out.println("******************************");

	}

	//generates random receipt number and prints it
	public static void randomReceiptNumber() {
		Random random = new Random();
		
		int receiptNum = random.nextInt(1000, 2000);
		
		System.out.println("receipt number      " + receiptNum);
	}
	
	//generates random date and prints it
	public static void randomDate() {
		//assign random date month
		int month = (int)((Math.random() * 12) + 1);
		
		Random randomYear = new Random();
		Random randomDay = new Random();
		
		//random year and day
		int year = randomYear.nextInt(1900, 2100);
		int day = (int)((Math.random() * 28) + 1);

		//display the month assigned as string followed by day and year
		switch (month)
		{
			case 1: System.out.println("January" + " " + day + " " + year); break;
			case 2: System.out.println("February" + " " + day + " " + year); break;
			case 3: System.out.println("March" + " " + day + " " + year); break;
			case 4: System.out.println("April" + " " + day + " " + year); break;
			case 5: System.out.println("May" + " " + day + " " + year); break;
			case 6: System.out.println("June" + " " + day + " " + year); break;
			case 7: System.out.println("July" + " " + day + " " + year); break;
			case 8: System.out.println("August" + " " + day + " " + year); break;
			case 9: System.out.println("September" + " " + day + " " + year); break;
			case 10: System.out.println("October" + " " + day + " " + year); break;
			case 11: System.out.println("November" + " " + day + " " + year); break;
			case 12: System.out.println("December" + " " + day + " " + year);
		}
	}
	
	//handles all tax calculations and prints statement about each item
	public static double handleTax(String itemName, double price, int tax, int numberItem) {
		double totalPrice = 0;
		double runningTotal = 0;
		
		//uppercase the first letter of the name
		String fixedName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
		
		//update price with new tax amount
		if(tax != 0)
			totalPrice = (price * .30) + price;
		else 
			totalPrice = price;
		
		//print the output with rounded total price of item
		System.out.println("item number" + " " + numberItem + " " + fixedName + " " + (double)Math.round(totalPrice));
		
		runningTotal = totalPrice;
		
		//return amount to add to running total
		return runningTotal;
	}
	
	//print total of all transactions
	public static void printTotal(int itemCount, double running) {
		System.out.println(itemCount + " items      total " + (double)Math.round(running));
	}
	
	//prints stars at end output
	public static void printStarsAtEnd() {
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
	}
	
	public static void main(String[] args) {
		
		//stars at beginning receipt
		printStarsAtBeginning();
		
		//random receipt number and date
		randomReceiptNumber();
		
		randomDate();
	
		//keep track number items
		int itemCount = 0;

		//declare Scanners
		Scanner scanName = new Scanner(System.in);
		Scanner scanPrice = new Scanner(System.in);
		
		//initialize variables
		String itemName = "";
		double itemPrice = 0.0;
		
		//running total for final total
		double running = 0.0;
		
		do {
			System.out.println("Write item name");
			itemName = scanName.nextLine();
			
			//if itemName is not "DONE" get price and calculate price with tax
			if(!itemName.equals("DONE")) {
				System.out.println("Write price");
				itemPrice = scanPrice.nextDouble();
				itemCount++;
				
				//add total price with tax to running total
				if(itemName.equals("food") || itemName.equals("Food"))  //tax is 0 because item food
					running += handleTax(itemName, itemPrice, 0, itemCount);
				
				else //tax is 30% because item is not food
					running += handleTax(itemName, itemPrice, 30, itemCount);
			}
			
		}while(!itemName.equals("DONE")); //if itemName is "DONE" stop loop
		
		//print count items and total cost
		printTotal(itemCount, running);
		
		//print stars at end
		printStarsAtEnd();
	}
	
}

