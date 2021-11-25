package main;

public class Main {

	public static void main(String[] args) {
		// Initialize game manager
		var gm = new GameManager();
		
		// create a hero from user input
		gm.createHuman();
		
		// choose dungeon
		gm.chooseDungeon();
		
		// launch the game
		gm.start();
}
}
