package dungeon;

import java.util.Iterator;
import java.util.List;

public abstract class Dungeon implements Cloneable, Iterable<Room>{
	/*
	 * Dungeon Prototype
	 * 
	 */
	private int difficulty;
	private List<Room> rooms;

	@Override
	public Dungeon clone() {
		return null;
	}

	public abstract Room getRoom(int level);
	
	@Override
	public Iterator<Room> iterator() {
		// TODO Auto-generated method stub
		return null;
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
