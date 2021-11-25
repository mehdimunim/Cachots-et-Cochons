package dungeon;
import java.util.List;

import character.Character;
import character.Hero;

public abstract class DungeonBuilder {
	private Dungeon dungeon;
	
	public Dungeon getDungeon() {
		/*
		 * Only one instance of dungeon
		 */
		if (dungeon == null) {
			dungeon = new Dungeon();
		}
		return dungeon;
	}
	
	
	public void setDifficulty(int difficulty) {
		dungeon.setDifficulty(difficulty);
	}
	
	public void addRoom(Room room) {
		dungeon.getRooms().add(room);
	}
	
	public void addRooms(List<Room> rooms) {
		dungeon.getRooms().addAll(rooms);
	}
	
	public void addCharacter(Character chara, int roomLevel, int indexToPut) {
		dungeon.getRoom(roomLevel).addCharacter(chara, indexToPut);
	}
	
	// create a dungeon
	public abstract void build(Hero hero);
}
