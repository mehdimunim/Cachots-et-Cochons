package dungeon;

import java.util.List;

public abstract class Dungeon implements Cloneable {
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
}
