package display;

import inventory.Item;

public class ItemPrinter implements Displayer {
	
	// static method to print a character
		public static void printItem(Item item) {
			
			System.out.println(item.toString());
		}

		@Override
		public void display() {
			// TODO Auto-generated method stub
			
		}


}
