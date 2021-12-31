package display;

import inventory.Inventory;
import inventory.Staircase;
import main.HumanPlayer;

public class InventoryPrinter {

	private static void display(Inventory invent) {

		System.out.println("INVENTORY");
		if (invent == null || invent.getItems() == null) {
			System.out.println("Empty inventory");
		} else {
			invent.getItems().stream().filter(it -> !(it instanceof Staircase)) // avoid staircase item just in case
					.forEachOrdered(it -> System.out.println(it.getFullDescription()));
		}
	}

	public static void update(HumanPlayer human) {
		Inventory invent = human.getChara().getInventory();
		display(invent);
	}
}
