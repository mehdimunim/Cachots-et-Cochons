package main;

import character.Hero;
import dungeon.*;
import display.*;

public class GameManager {
	/*
	 * Manages the game
	 */

	private Room currentRoom;
	private Dungeon dungeon;
	private HumanPlayer humanPlayer;

	public Room nextRoom() {
		
		int level = currentRoom.getLevel();
		this.currentRoom = dungeon.getRoom(level + 1);
		return this.currentRoom;
	}

	public void createDefaultHuman() {
		
		Hero hero = Hero.createDefaultHero();
		Tile firstTile = dungeon.getRoom(0).getTile(0);
		humanPlayer = new HumanPlayer(hero, firstTile);
		
	}

	public void start() {

		currentRoom = dungeon.getRoom(0);
		currentRoom.addHero(humanPlayer.getChara());
		RoomPrinter.display(currentRoom, humanPlayer.getChara());
	}

	public void createBasicDungeon() {
		var bd = new BasicDungeonBuilder();
		bd.build();
		dungeon = bd.getDungeon();
	}

}
