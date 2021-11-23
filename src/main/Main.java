package main;

import dungeon.*;
import character.MonsterFactory;
import display.*;
import character.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("The games starts");

		// create and add the hero
		Hero hero = Hero.createDefaultHero();
		BasicDungeon bd = new BasicDungeon(hero);
		
		Room room0 = bd.getRoom(0);

		// display the room with monsters and the hero 
		RoomPrinter.display(room0, hero);

		RoomManager rm = new RoomManager();
		
		int i = 0;
		while (i < 10) {
		for (AIPlayer player : rm.getAIPlayers()) {
			rm.giveTurnTo(player);
		}
		
		}
	}
		

}
