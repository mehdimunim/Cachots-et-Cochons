package display;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomPrinter implements Displayer{

	private dungeon.Room room;
	private character.Hero hero;
	private List<character.Character> listCharacter;

	public RoomPrinter(dungeon.Room room, character.Hero hero) {
		this.room = room;
		this.hero = hero;
	};

	private void printHeader() {

		System.out.println("Room" + room.getDescription());

	}

	private void printHeroDescription() {

		String heroDescription = "";

		heroDescription += hero.getXP() + " ";
		heroDescription += hero.getHP() + " ";
		heroDescription += hero.getAttack() + " ";
		heroDescription += hero.getDefense() + " ";

		System.out.println(heroDescription);
	}

	private void printTiles() {

		String firstLine = "*".repeat(room.getX());

		System.out.println(firstLine);

		Iterator<dungeon.Tile> it = room.getTiles().iterator();

		while (it.hasNext()) {

			TilePrinter.printTile(it.next());

		}

	}
	
	@Override
	public void display() {
		printHeader();
		printTiles();
		printHeroDescription();
		
	}

}
