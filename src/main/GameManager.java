package main;

import dungeon.*;

public class GameManager {
	/*
	 * Manages the game
	 */

	Room currentRoom;
	Dungeon dungeon;
	
	public Room nextRoom() {
		int level = currentRoom.getLevel();
		this.currentRoom = dungeon.getRoom(level+1);
		return this.currentRoom;
	}
}
