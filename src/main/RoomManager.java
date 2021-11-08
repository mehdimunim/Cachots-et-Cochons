package main;

import java.util.List;

public class RoomManager {
	/*
	 * Manages the room
	 */
	
	List<AIPlayer> AIPlayers;
	dungeon.Room currentRoom;
	HumanPlayer hero;
	Player currentPlayer;
	
	public void giveTurnTo(Player player) {
		player.play();
	}
	
	public void removeFromGame(character.Character character) {
		
	};
	
	public void addToGame(character.Character character) {}
	
	public boolean isMovePossible() {
		return true;
	}
	public boolean hasLost(character.Hero hero) {
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
