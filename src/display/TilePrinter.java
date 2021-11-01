package display;

import inventory.Item;
import dungeon.Tile;

public class TilePrinter {

	public static void display(Tile tile) {

		// set priority for displaying characters against items

		character.Character chara = tile.getCharacter();
		Item item = tile.getItem();

		// empty tile
		if (chara == null && item == null) {

			System.out.print(" ");
		}

		// tile with a character
		else if (item == null) {
			CharacterPrinter.display(chara);
		}

		// tile with item
		else {
			ItemPrinter.display(item);
		}

	}
}
