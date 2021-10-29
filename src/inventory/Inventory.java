package inventory;

import java.util.List;

public class Inventory {

	List<Item> items;

	int capacity;

	public void addItem(Item item) {

		if (items.size() < capacity) {
			items.add(item);
		}
		
		else {
			
		}

	};

	public void removeItem(Item item) {

		items.remove(item);

	};
}
