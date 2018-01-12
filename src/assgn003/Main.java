/*
**Group 14 ** 
 
 *Dennis Mandela - Sp13/00819/15
 *Sila Samuel - S13/09681/15
 *Collins Murithi - S13/09318/15
 *Oliver Muthomi - S13/09689/15
 *Gehard Njoroge - S13/09683/15
 */

package assgn003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Declare and Initialize Arrays and variable to store the data
	static ArrayList<String> items = new ArrayList<>();
	static ArrayList<ArrayList<String>> orders = new ArrayList<>();

	static int valueEntered = 0;

	// Constructor to be used when returning to the main method from other classes
	public Main(ArrayList<String> _items, ArrayList<ArrayList<String>> _orders, String[] args) {
		items = _items;
		orders = _orders;
		main(args);
	}

	// Main Method
	public static void main(String[] args) {

		// Prompt for initial action
		System.out.println("Chose: \n\t'1' To place an order. \n\t'2' To print orders. ");

		// Check input validity to ensure only an integer in entered
		try {
			valueEntered = new Scanner(System.in).nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid input.\n\n");
			main(args);
		}

		// Check input validity to ensure only 1 or 2 can be entered
		if (valueEntered == 1 || valueEntered == 2) {

			// Initialize the Operations class
			Operations operations = new Operations(items, orders, args);

			// Handle events according to the entered value
			switch (valueEntered) {
			case 1:
				operations.placeOrder();
				break;
			case 2:
				operations.printOrders();
				break;
			default:
				System.out.println("Please choose '1' or '2' \n\n");
				main(args);
				break;
			} // end switch

		} // end if

	} // end main method

} // end class
