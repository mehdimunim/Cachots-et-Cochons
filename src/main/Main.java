package main;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) {
		// Initialize game manager
		GameManager gm = new GameManager();

		// choose dungeon
		try {
			gm.readBasicDungeon("data//example//BasicDungeonExample.xml");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//gm.createBasicDungeon()

		// create a hero from user input
		gm.createDefaultHuman();

		// launch the game
		gm.start();
	}
}
