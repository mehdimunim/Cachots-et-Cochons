package display;

import dungeon.Room;
import dungeon.Tile;
import character.Hero;

public class RoomPrinter {

	public static void display(Room room, Hero hero) {

		int x = room.getX();
		int y = room.getY();
		
		//+2 to include borders
		System.out.println("*".repeat(x+2));
		// display tiles
		for (Tile tile : room.getTiles()) {
			int yPos = tile.getYPosition();

			if (yPos == 1) {
				System.out.print("*");
			}

			TilePrinter.display(tile);

			if (yPos == y) {
				System.out.print("*\n");
			}
			;

		}
		System.out.println("*".repeat(x+2));

		// display info
		InfoPrinter.display(hero, room);
	}

}
