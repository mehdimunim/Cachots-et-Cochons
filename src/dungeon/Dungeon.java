package dungeon;

import java.util.Iterator;
import java.util.List;

public class Dungeon implements Iterable<Room>{
	/*
	 * Dungeon 
	 * 
	 */
	private int difficulty;
	private List<Room> rooms;
	
	@Override
	public Dungeon clone() {
		return null;
	}

	public Room getRoom(int level) {
		return rooms.get(level);
	};
	
	public void setRoom(int level, Room room) {
		rooms.set(level, room);
	};
	
	
	@Override
	public Iterator<Room> iterator() {
		return rooms.iterator();
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
}
