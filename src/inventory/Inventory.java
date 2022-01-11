package inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The inventory contains items that can be used by the hero.
 *
 * @author Mehdi
 *
 */
public class Inventory implements Iterable<Item> {
	private List<Item> items;
	/**
	 * Limit of the inventory
	 */
	private int capacity;

	public Inventory(int capacity) {
		items = new ArrayList<>();
		this.capacity = capacity;
	}

	/**
	 * Add an item to the inventory
	 *
	 * @param item
	 * @throws FullInventoryException
	 */
	public void addItem(Item item) throws FullInventoryException {

		if (items.size() < capacity) {
			items.add(item);
		} else {
			throw new FullInventoryException("The inventory is full");
		}

	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	public void removeItem(Item item) {

		items.remove(item);

	}

}
