package main;

import dungeon.*;
import character.MonsterFactory;
import display.*;
import character.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("The game starts");

		// empty room of dimension 10 * 10
		Room room = new Room(10, 10, "", 0);
		
		// spawns two boars
		
		MonsterFactory.spawnBoar(room.getTile(1));
		MonsterFactory.spawnSow(room.getTile(2));
		MonsterFactory.spawnShoat(room.getTile(15));
		MonsterFactory.spawnBoar(room.getTile(10));
		
		// create and add the hero
		Hero hero = Hero.getDefaultHero();
		room.addHero(hero);

		// display the room with monsters and the hero 
		RoomPrinter.display(room, hero);

		RoomManager rm = new RoomManager();

		for (AIPlayer player : rm.getAIPlayers()) {
			player.play();
		}

		rm.getHumanPlayer().play();

	}

}
