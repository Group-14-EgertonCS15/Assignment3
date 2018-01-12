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

public class Operations {

	// Declare and Initialize Arrays and variable to store the data
	String[] args;
	ArrayList<String> items;
	ArrayList<ArrayList<String>> orders = new ArrayList<>();
	int numbersOfOrders = 0;
	int position = 0;

	// Constructor to initialize variables
	public Operations(ArrayList<String> items, ArrayList<ArrayList<String>> orders, String[] args) {
		this.items = items;
		this.orders = orders;
		this.args = args;
	}

	// Method to handle placing orders
	public void placeOrder() {

		// Monitor number of orders placed to ensure only 5 orders can be processed at a
		// go
		while (numbersOfOrders < 5) {

			// Prompt user to select items for the order
			System.out.println(
					"Choose items for your order separated by spaces: \n\t 1. Chapati \n\t 2. Ugali \n\t 3. Beef \n\t 4. Vegetables \n\t 5. Soda ");

			String orderInput = new Scanner(System.in).nextLine();

			// Validate data entered
			try {
				// Split the line data at spaces to get individual order items
				String[] strings = orderInput.trim().split("\\s+");

				// Ensure more than 3 items are ordered
				if (strings.length < 3) {
					System.out.println("Your order must have at least 3 items. Try again [y/n].");

					String s = new Scanner(System.in).nextLine();
					if (s.equals("Y") || s.equals("y")) {
						placeOrder();
					}
					if (s.equals("N") || s.equals("n")) {
						new Main(items, orders, args);
					} else {
						System.out.println("Invalid Input. ['R'try / 'Q'uit]");
						handleUserPrompts();
					}
				}

				// Re-initialize items array after every order to prevent adding items to
				// existing order
				items = new ArrayList<>();

				// Add selected items to array
				for (int i = 0; i < strings.length; i++) {
					items.add(convertInputToNames(Integer.parseInt(strings[i])));
				}

				// Add order to array of orders
				orders.add(items);

				// Prompt users for more orders
				System.out.println("\nOrder added. Select 1 to add another order or Anything else to print orders.");

				// Quit adding orders and print the orders
				if (!new Scanner(System.in).nextLine().trim().equals("1")) {
					System.out.print("\n");
					printOrders();
				}
				// Else continue adding orders

			} catch (Exception e) {
				System.out.println("Invalid Input. ['R'try / 'Q'uit]");
				handleUserPrompts();
			}

			// Increment control variable to monitor orders
			numbersOfOrders++;
		}

		// Prompt user when more than 5 orders are placed
		System.out.println("\n\nMaximum orders are already placed. \nPLease wait and try again.\n");
		new Main(items, orders, args);

	} // end placeOrdersMtd

	// Method to handle viewing orders
	public void printOrders() {

		// Check if orders are available
		if (orders.size() == 0) {
			System.out.println("There are no placed orders at this time. ['C'ontinue / 'Q'uit]");
			handleUserPrompts();
		}

		// Display orders if available
		else if (orders.size() >= 1) {

			System.out.println("Placed Orders:");

			// Loop to iterate orders
			for (ArrayList<String> order : orders) {
				position++;
				System.out.print("Order " + position + ": ");

				// Loop to iterate items in the order
				for (int i = 0; i < order.size(); i++) {
					System.out.print(order.get(i) + " ");
				}

				System.out.println();
			}

			// Prompt user after printing orders
			System.out.println("\n\nAll placed orders have been processed. ['C'ontinue / 'D'ismiss orders / 'Q'uit]");
			handleUserPrompts();

		} // end if_else

	}// end printOrders Mtd

	// Convert item numbers to names
	private String convertInputToNames(int i) {

		String name = "";

		switch (i) {
		case 1:
			name = "[Chapati - KSh 10]";
			break;
		case 2:
			name = "[Ugali - KSh 20]";
			break;
		case 3:
			name = "[Beef - KSh 50]";
			break;
		case 4:
			name = "[Vegetables - KSh 20]";
			break;
		case 5:
			name = "[Soda - KSh 30]";
			break;

		}

		return name;
	} // end convertInputToNames Mtd

	// Handle other prompts
	public void handleUserPrompts() {
		String s = new Scanner(System.in).nextLine();

		if (s.equals("C") || s.equals("c")) {
			new Main(items, orders, args);
		}
		if (s.equals("D") || s.equals("d")) {
			new Main(items, orders, args);

			items.clear();
			orders.clear();
		}
		if (s.equals("Q") || s.equals("q")) {
			System.exit(0);
		}
		if (s.equals("R") || s.equals("r")) {
			placeOrder();
		} else {
			System.out.println("Invalid input detected. Try again.\n");
			handleUserPrompts();

		}

	} // end handleUserPrompts Mtd
} // end class
