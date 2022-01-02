package main;

import java.text.ParseException;

import main.GameManager.DeadPlayerException;

public class Main {

	public static void main(String[] args) {
		// Initialize game manager
		GameManager gm = new GameManager();

		// choose dungeon
		try {
			gm.readBasicDungeon("data//example//DungeonExample.xml");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//gm.createBasicDungeon()

		// create a hero from user input
		gm.createDefaultHuman();

		// launch the game
		try {
			gm.start();
		} catch (DeadPlayerException e) {
			e.printMessage();
		}
	}
}
