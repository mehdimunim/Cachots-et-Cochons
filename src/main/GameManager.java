package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		AIPlayers = new ArrayList<>();
		// create a player where a character is present
		for (Tile tile : currentRoom) {
			// need to avoid initalizing hero as AI
			if (!tile.equals(humanPlayer.getCurrentTile()))
				tile.getCharacter().ifPresent(chara -> AIPlayers.add(new AIPlayer(chara, tile)));
		}
	}

	public void updateAIPlayers() {

		if (AIPlayers == null) {
			initAIPlayers();
		} else {
			AIPlayers.stream().forEach(play -> play.setChara(play.getCurrentTile().getCharacter().get()));
			AIPlayers.stream().filter(ai -> ai.isDead()).forEach(ai -> removeFromGame(ai));
		}
	}

	public void start() throws InterruptedException {

		// init room
		currentRoom = dungeon.getRoom(0);

		// iterate over all rooms
		while (!currentRoom.isLast()) {
			updateAIPlayers();
			// refresh printer for the new turn
			notifyPrinters();
			// iterate over all players
			while (!hasWonRoom()) {
				// iterate over AI players
				for (AIPlayer aiPlayer : AIPlayers) {
					giveTurnTo(aiPlayer);
					notifyPrinters();
					// wait between AI turns
					// TODO: solve IllegalMonitorException
					// wait(1000);
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

	public List<AIPlayer> getAIPlayers() {
		return this.AIPlayers;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}
}
