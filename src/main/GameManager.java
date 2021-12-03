package main;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	private List<AIPlayer> AIPlayers;
	//private Player<character.Character> currentPlayer;

	public Optional<Room> nextRoom() {

		int level = currentRoom.getLevel();

		if (currentRoom.isLast()) {

			return Optional.empty();

		}

		else {
			currentRoom = dungeon.getRoom(level + 1);
			return Optional.of(currentRoom);
		}

	}

	public void createDefaultHuman() {

		Hero hero = Hero.createDefaultHero();
		Tile firstTile = dungeon.getRoom(0).getTile(0);
		humanPlayer = new HumanPlayer(hero, firstTile);
		dungeon.getRoom(0).addHero(humanPlayer.getChara());

	}
	
	public void initAIPlayers() {
		AIPlayers = currentRoom.getCharacters().stream().map(chara -> new AIPlayer(chara,new Tile())).collect(Collectors.toList());
	}

	public void start() throws InterruptedException {
		
		// init room
		currentRoom = dungeon.getRoom(0);
		
		// iterate over all rooms
		while (!currentRoom.isLast()) {
			initAIPlayers();
			// refresh printer for the new turn
			notifyPrinters();
			// iterate over all players
			while (!hasWonRoom()) {
				// iterate over AI players
				for (AIPlayer player : AIPlayers) {
					giveTurnTo(player);
					notifyPrinters();
					// wait between AI turns
					wait(1000);
				}
				// give turn to human
				giveTurnTo(humanPlayer);
				notifyPrinters();
			}
			nextRoom();
		}

	}

	public void createBasicDungeon() {
		var bd = new BasicDungeonBuilder();
		bd.build();
		dungeon = bd.getDungeon();
		
	}
	
	public void notifyPrinters() {
		RoomPrinter.update(currentRoom, humanPlayer);
		InfoPrinter.update(currentRoom, humanPlayer);
		
	}

	public <T extends character.Character> void giveTurnTo(Player<T> player) {

		List<Tile> reachableTiles = player.getReachableTiles(currentRoom);
		player.play(reachableTiles);
	}

	public void removeFromGame(AIPlayer player) {
		AIPlayers.remove(player);
	};

	public void addToGame(AIPlayer player) {
		AIPlayers.add(player);
	}

	public boolean hasWonRoom() {
		return AIPlayers.isEmpty();
	}

	public List<AIPlayer> getAIPlayers() {
		return this.AIPlayers;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}
}
