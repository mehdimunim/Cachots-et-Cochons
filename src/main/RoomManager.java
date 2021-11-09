package main;

import java.util.List;

public class RoomManager {
	/*
	 * Manages the room
	 */
	
	private List<AIPlayer> AIPlayers;
	private dungeon.Room currentRoom;
	private HumanPlayer hero;
	private Player<character.Character> currentPlayer;
	
	public void giveTurnTo(Player player) {
		player.play();
	}
	
	public void removeFromGame(Player player) {
		AIPlayers.remove(player);
	};
	
	public void addToGame(AIPlayer player) {
		AIPlayers.add(player);
	}
	
	public boolean hasLost() {
		return false;
	}
	public boolean hasWon(character.Hero hero) {
		return false;
	}

	public List<AIPlayer> getAIPlayers() {
		return this.AIPlayers;
	}
	
	public HumanPlayer getHumanPlayer() {
		return this.hero;
	}
}
