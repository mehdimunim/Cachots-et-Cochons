package main;

import java.text.ParseException;

import main.GameManager.DeadPlayerException;

public class Main {

	public static void main(String[] args) {
		// Initialize game manager
		GameManager gm = new GameManager();

		// choose dungeon
		try {
			gm.chooseDungeon();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
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
