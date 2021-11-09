package inventory;

import java.util.List;

public class Inventory {
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
		
		else {
			
		}

	};

	public void removeItem(Item item) {

		items.remove(item);

	};
	
	
	//TODO: m�thode pour v�rifier la pr�sence d'un type d'objet
}
