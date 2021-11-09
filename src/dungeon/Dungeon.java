package dungeon;

import java.util.Iterator;
import java.util.List;

public abstract class Dungeon implements Cloneable, Iterable<Room>{
	/*
	 * Dungeon Prototype
	 * 
	 */
	int difficulty;
	List<Room> rooms;

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
	
}
