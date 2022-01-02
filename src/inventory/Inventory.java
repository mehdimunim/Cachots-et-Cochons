package inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Iterable<Item> {
	/*
	 * Coder le comportement des objets
	 */
	private List<Item> items;

	private int capacity;

	public Inventory(int capacity) {
		items = new ArrayList<>();
		this.capacity = capacity;
	}

	public void addItem(Item item) {

		if (items.size() < capacity) {
			items.add(item);
		}

	}

	public List<Item> getItems() {
		return items;
	}

	public boolean has(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	public void removeItem(Item item) {

		items.remove(item);

	}

}
