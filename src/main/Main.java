package main;

public class Main {

	public static void main(String[] args) {
		// Initialize game manager
		var gm = new GameManager();

		// choose dungeon
		gm.createBasicDungeon();

		// create a hero from user input
		gm.createDefaultHuman();

		// launch the game
		try {
			gm.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
