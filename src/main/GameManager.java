package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import character.Hero;
import display.InfoPrinter;
import display.InventoryPrinter;
import display.RoomPrinter;
import dungeon.BasicDungeonBuilder;
import dungeon.BasicDungeonXMLParser;
import dungeon.Dungeon;
import dungeon.InvalidRoomException;
import dungeon.NonEmptyTileException;
import dungeon.Room;
import dungeon.Tile;

/**
 * Class to manage the game
 *
 * @author Mehdi
 *
 */
public class GameManager {

	private Room currentRoom;
	private Dungeon dungeon;
	private HumanPlayer humanPlayer;
	private List<AIPlayer> AIPlayers;

	private boolean hasWon = false;

	public void addToGame(AIPlayer player) {
		try {
			player.getCurrentTile().addCharacter(player.getChara());
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}
		AIPlayers.add(player);
	}

	public void changeRoom(Room adjRoom) {
		currentRoom = adjRoom;
		initAIPlayers();
	}

	public void chooseDungeon() throws ParseException, InvalidRoomException {
		System.out.println("Choose dungeon");
		System.out.println("\tCreate Default Dungeon      [1]");
		System.out.println("\tRead Basic Dungeon Example  [2]");
		System.out.println("\tRead Dungeon Example (1)    [3]");
		System.out.println("\tRead Dungeon Example (2)    [4]");
		@SuppressWarnings("resource")
		int choice = new Scanner(System.in).nextInt();
		switch (choice) {
		case 2:
			readBasicDungeon("data//example//BasicDungeonExample.xml");
			break;
		case 3:
			readBasicDungeon("data//example//DungeonExample1.xml");
			break;
		case 4:
			readBasicDungeon("data//example//DungeonExample2.xml");
			break;
		default:
			createBasicDungeon();
			break;
		}
	}

	public void createBasicDungeon() {
		BasicDungeonBuilder bd = new BasicDungeonBuilder();
		bd.build();
		dungeon = bd.getDungeon();

	}

	public void createDefaultHuman() {

		Hero hero = Hero.createDefaultHero();
		Tile firstTile = dungeon.getRoom(0).getTile(0);
		humanPlayer = new HumanPlayer(hero, firstTile);
		try {
			dungeon.getRoom(0).addHero(humanPlayer.getChara());
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}

	}

	public void endMessage() {
		System.out.println("\nYOU WON");
	}

	public List<AIPlayer> getAIPlayers() {
		return AIPlayers;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}

	public <T extends character.Character> void giveTurnTo(Player<T> player) throws DeadPlayerException {
		List<Tile> reachableTiles = player.getReachableTiles(currentRoom);
		player.play(reachableTiles);
		if (player.isOnStaircase()) {
			if (player.choosesToGoStaircase()) {
				// go up if the staircase is down
				Room adjRoom = player.isOnUp() ? prevRoom() : nextRoom();
				Command goStaircase = new GoStaircaseCommand<T>(player, adjRoom);
				goStaircase.execute();
				changeRoom(adjRoom);
			}
		}
		if (humanPlayer.isDead()) {
			throw new DeadPlayerException();
		}

	}

	public void greetings() {
		System.out.println("Hello!");
	}

	public boolean hasWonDungeon() {
		return hasWon;
	}

	public boolean hasWonRoom() {
		return AIPlayers.isEmpty();
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

	public void initHuman() {
		humanPlayer.goTo(currentRoom.getFirstTile());
	}

	public boolean isFirstRoom() {
		return currentRoom.getLevel() == 0;
	}

	public boolean isLastRoom() {
		return currentRoom.getLevel() == dungeon.size() - 1;
	}

	public Room nextRoom() {
		int level = currentRoom.getLevel();
		Room room;
		try {
			room = dungeon.getRoom(level + 1);
		} catch (IndexOutOfBoundsException e) {
			hasWon = true;
			room = currentRoom;
		}
		return room;
	}

	public void notifyPrinters() {
		RoomPrinter.update(currentRoom, humanPlayer);
		InfoPrinter.update(currentRoom, humanPlayer);
		InventoryPrinter.update(humanPlayer);

	}

	public Room prevRoom() {
		int level = currentRoom.getLevel();
		return dungeon.getRoom(level - 1);
	}

	public void readBasicDungeon(String xml) throws ParseException, InvalidRoomException {
		BasicDungeonXMLParser parser = new BasicDungeonXMLParser();
		dungeon = parser.getDungeon(xml);
	}

	public void removeFromGame(AIPlayer player) {
		player.getCurrentTile().removeCharacter();
		AIPlayers.remove(player);
	}

	public void start() throws DeadPlayerException {

		// init room
		currentRoom = dungeon.getRoom(0);
		// init AIPlayers
		initAIPlayers();
		// iterate over all rooms
		while (!hasWonDungeon()) {
			// refresh printer for the new turn
			notifyPrinters();
			// iterate over all players
			while (!hasWonRoom()) {
				// iterate over AI players
				for (AIPlayer aiPlayer : AIPlayers) {
					giveTurnTo(aiPlayer);
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
		endMessage();

	}

	public void updateAIPlayers() {
		List<AIPlayer> deadAIs = AIPlayers.stream().filter(ai -> ai.isDead()).collect(Collectors.toList());
		deadAIs.forEach(ai -> removeFromGame(ai));
	}
}
