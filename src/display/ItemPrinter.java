package display;

import inventory.Item;

public class ItemPrinter {

	/**
	 * static method to print a character
	 *
	 * @param item
	 */
	public static void display(Item item) {

		System.out.print(item.toString());

	}

}
