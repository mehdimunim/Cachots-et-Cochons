package dungeon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Dungeon implements Iterable<Room>, Cloneable {
	/*
	 * Dungeon 
	 * 
	 */
	private int difficulty;
	private List<Room> rooms;
	
	@Override
	public Dungeon clone() throws CloneNotSupportedException {
		return (Dungeon) super.clone();
	}
	
	public void addRoom(Room room) {
		if (rooms == null) {
			rooms = new ArrayList<Room>();
		}
		rooms.add(room);
		
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

	public int size() {
		return rooms.size();
	}
	
}
