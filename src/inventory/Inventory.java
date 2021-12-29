package inventory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory implements Iterable<Item>{
	/*
	 * Coder le comportement des objets
	 */
	private List<Item> items;

	private int capacity;
	
	public Inventory(int capacity) {
		this.capacity = capacity;
	}

	public void addItem(Item item) {

		if (items.size() < capacity) {
			items.add(item);
		}

	};

	public void removeItem(Item item) {

		items.remove(item);

	}

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	public boolean has(String string) {
		// TODO Auto-generated method stub
		return false;
	};
	
}
