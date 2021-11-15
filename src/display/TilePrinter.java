package display;

import inventory.Item;

import java.util.Optional;

import character.Character;
import dungeon.Tile;

public class TilePrinter {

	public static void display(Tile tile) {

		// set priority for displaying characters against items

		Optional<Character> chara = tile.getCharacter();
		Optional<Item> item = tile.getItem();

		// empty tile
		
		if (chara.isEmpty() && item.isEmpty()) {

			System.out.print("  ");
		}

		// tile with a character
		else if (item.isEmpty()) {
			chara.ifPresent(ch -> CharacterPrinter.display(ch));
			System.out.print(" ");
		}

		// tile with item
		else {
			item.ifPresent(it -> ItemPrinter.display(it));
			System.out.print(" ");
		}

	}
}
