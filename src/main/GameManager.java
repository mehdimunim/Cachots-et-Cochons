package main;

import dungeon.*;

public class GameManager {
	/*
	 * Manages the game
	 */

	private Room currentRoom;
	private Dungeon dungeon;
	private HumanPlayer humanPlayer;
	
	public Room nextRoom() {
		int level = currentRoom.getLevel();
		this.currentRoom = dungeon.getRoom(level+1);
		return this.currentRoom;
	}
	
	
	public void buildBasicDungeon() {
		var bdb = new BasicDungeonBuilder();
		bdb.build(humanPlayer.getChara());
		dungeon = bdb.getDungeon();
	}


	public void createHuman() {
		// TODO Auto-generated method stub
		
	}


	public void start() {
		// TODO Auto-generated method stub
		
	}


	public void chooseDungeon() {
		// TODO Auto-generated method stub
		
	}
	
	
}
