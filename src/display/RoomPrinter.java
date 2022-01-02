package display;

import character.Hero;
import dungeon.Room;
import dungeon.Tile;
import main.HumanPlayer;

public class RoomPrinter {

	public static void display(Room room, Hero hero) {

		int y = room.getY();

		// +2 to include borders
		System.out.println("* ".repeat(y + 2));
		// display tiles
		for (Tile tile : room) {
			int yPos = tile.getYPosition();

			if (yPos == 1) {
				System.out.print("* ");
			}

			TilePrinter.display(tile);

			if (yPos == y) {
				System.out.print("*\n");
			}

		}
		System.out.println("* ".repeat(y + 2));
	}

	public static void update(Room currentRoom, HumanPlayer humanPlayer) {
		display(currentRoom, humanPlayer.getChara());
	}

}
