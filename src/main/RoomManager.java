package main;

import java.util.List;

public class RoomManager {
	
	List<character.Character> AIPlayers;
	dungeon.Room currentRoom;
	character.Hero hero;
	character.Character currentPlayer;
	
	public void play(character.Character character) {
		
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
}
