package dungeon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A Dungeon is a 3 dimension matrix of tiles. Implements the Prototype design
 * pattern and is built by a builder class.
 *
 * @author Mehdi
 *
 */
public abstract class Dungeon implements Iterable<Room>, Cloneable {
	private int difficulty;
	/**
	 * The first room is accessed first (first in, first out)
	 */
	private List<Room> rooms;

	/**
	 * Append a room
	 *
	 * @param room
	 */
	public void addRoom(Room room) {
		if (rooms == null) {
			rooms = new ArrayList<Room>();
		}
		rooms.add(room);

	}

	@Override
	public Dungeon clone() throws CloneNotSupportedException {
		return (Dungeon) super.clone();
	}

	public int getDifficulty() {
		return difficulty;
	}

	public Room getRoom(int level) {
		return rooms.get(level);
	}

	public List<Room> getRooms() {
		return rooms;
	}

	@Override
	public Iterator<Room> iterator() {
		return rooms.iterator();
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setRoom(int level, Room room) {
		rooms.set(level, room);
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Height of the dungeon
	 *
	 * @return number of rooms
	 */
	public int size() {
		return rooms.size();
	}

}
