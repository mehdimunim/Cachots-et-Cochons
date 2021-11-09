package main;

import dungeon.*;

public class GameManager {
	/*
	 * Manages the game
	 */

	private Room currentRoom;
	private Dungeon dungeon;
	
	public Room nextRoom() {
		int level = currentRoom.getLevel();
		this.currentRoom = dungeon.getRoom(level+1);
		return this.currentRoom;
	}
}
