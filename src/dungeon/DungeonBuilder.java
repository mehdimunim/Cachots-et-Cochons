package dungeon;
import java.util.List;

import character.Character;
import character.Hero;

public abstract class DungeonBuilder {
	private Dungeon dungeon = new Dungeon();
	
	public Dungeon getDungeon() {
		return dungeon;
	}
	
	public abstract void createRoom(int roomDim, int level);
	
	public void setDifficulty(int difficulty) {
		dungeon.setDifficulty(difficulty);
	}
	
	public void createAllRandomStaircases() {
		/**
		 * Create random staircases connecting each room to the next level if it exists.
		 */
		var sb = new StaircaseBuilder();
		
		for (int i = 0; i< dungeon.size() - 1; i++) {
			
			Room downRoom = dungeon.getRoom(i);
			Room upRoom = dungeon.getRoom(i+1);
			
			sb.createStaircase(downRoom.getRandomTile(), upRoom.getRandomTile());
			
		}
	}
	
	public void addRoom(Room room) {
		dungeon.addRoom(room);
	}
	
	public void addRooms(List<Room> rooms) {
		dungeon.getRooms().addAll(rooms);
	}
	
	
	public void addHero(Hero hero) {
		// The hero is necessary at tile 0
		dungeon.getRoom(0).addHero(hero);
	}
	
	// create a dungeon
	public abstract void build();


	public void setDifficulty() {
		// TODO Auto-generated method stub
		
	}
}
