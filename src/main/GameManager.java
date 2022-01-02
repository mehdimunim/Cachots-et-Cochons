package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import character.Hero;
import display.InfoPrinter;
import display.InventoryPrinter;
import display.RoomPrinter;
import dungeon.BasicDungeonBuilder;
import dungeon.Dungeon;
import dungeon.DungeonXMLParser;
import dungeon.Room;
import dungeon.Tile;

public class GameManager {
	/*
	 * Manages the game
	 */

	private Room currentRoom;
	private Dungeon dungeon;
	private HumanPlayer humanPlayer;
	private List<AIPlayer> AIPlayers;
	
	
	public boolean isLastRoom() {
		return currentRoom.getLevel() == dungeon.size()-1;
	}
	public boolean isFirstRoom() {
		return currentRoom.getLevel() == 0;
	}
	public Room nextRoom() {
		int level = currentRoom.getLevel();
		return dungeon.getRoom(level + 1);
	}

	public void changeRoom(Room adjRoom) {
		currentRoom = adjRoom;
	}
	
	public void initHuman() {
		humanPlayer.goTo(currentRoom.getFirstTile());
	}

	public Room prevRoom() {
		int level = currentRoom.getLevel();
		return dungeon.getRoom(level - 1);
	}

	public void createDefaultHuman() {

		Hero hero = Hero.createDefaultHero();
		Tile firstTile = dungeon.getRoom(0).getTile(0);
		humanPlayer = new HumanPlayer(hero, firstTile);
		dungeon.getRoom(0).addHero(humanPlayer.getChara());

	}

	public void initAIPlayers() {

		AIPlayers = new ArrayList<>();
		// create a player where a character is present
		for (Tile tile : currentRoom) {
			// need to avoid initializing hero as AI
			if (!tile.equals(humanPlayer.getCurrentTile()))
				tile.getCharacter().ifPresent(chara -> AIPlayers.add(new AIPlayer(chara, tile)));
		}
	}

	public void updateAIPlayers() {
		List<AIPlayer> deadAIs = AIPlayers.stream().filter(ai -> ai.isDead()).collect(Collectors.toList());
		deadAIs.forEach(ai -> removeFromGame(ai));
	}

	public void start() {

		// init room
		currentRoom = dungeon.getRoom(0);
		// iterate over all rooms
		while (!hasWonDungeon()) {
			initAIPlayers();
			// refresh printer for the new turn
			notifyPrinters();
			// iterate over all players
			while (!hasWonRoom()) {
				// iterate over AI players
				for (AIPlayer aiPlayer : AIPlayers) {
					giveTurnTo(aiPlayer);
					// wait between AI turns
					// TODO: solve IllegalMonitorException
					// wait(1000);
				}
				notifyPrinters();
				// give turn to human
				giveTurnTo(humanPlayer);
				// remove dead monsters
				updateAIPlayers();
				// update display
				notifyPrinters();
			}
			changeRoom(nextRoom());
			initHuman();
		}

	}

	public void createBasicDungeon() {
		BasicDungeonBuilder bd = new BasicDungeonBuilder();
		bd.build();
		dungeon = bd.getDungeon();

	}
	
	public void readBasicDungeon(String xml) throws ParseException {
		DungeonXMLParser parser = new DungeonXMLParser();
		dungeon = parser.getDungeon(xml);
	}

	public void notifyPrinters() {
		RoomPrinter.update(currentRoom, humanPlayer);
		InfoPrinter.update(currentRoom, humanPlayer);
		InventoryPrinter.update(humanPlayer);

	}

	public <T extends character.Character> void giveTurnTo(Player<T> player) {

		List<Tile> reachableTiles = player.getReachableTiles(currentRoom);
		player.play(reachableTiles);
		if (player.isOnStaircase()) {
			if (player.choosesToGoStaircase()) {
				// go up if the staircase is down 
				Room adjRoom = player.isOnUp() ? prevRoom() : nextRoom();
				player.goStaircase(adjRoom);
				changeRoom(adjRoom);
			}
		}

	}


	public void removeFromGame(AIPlayer player) {
		player.getCurrentTile().removeCharacter();
		AIPlayers.remove(player);
	};
	
	public void addToGame(AIPlayer player) {
		player.getCurrentTile().addCharacter(player.getChara());
		AIPlayers.add(player);
	}

	public boolean hasWonRoom() {
		return AIPlayers.isEmpty();
	}
	
	public boolean hasWonDungeon() {
		return false;
	}

	public List<AIPlayer> getAIPlayers() {
		return this.AIPlayers;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}
}
