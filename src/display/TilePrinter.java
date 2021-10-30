package display;

import inventory.Item;

public class TilePrinter implements Displayer {

	
	public static void printTile(dungeon.Tile tile) {
		
		Character chara = tile.getCharacter();
		Item item = tile.getItem();
		
		if (chara == null && item == null) {
			
			System.out.println(" ");
		}
		
		else if (item == null){
			CharacterPrinter.printCharacter(chara);
		}
		
		else {
			ItemPrinter.printItem(item);
		}
	
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}

