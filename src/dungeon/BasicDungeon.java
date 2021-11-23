package dungeon;

import java.util.List;

import character.Hero;
import character.MonsterFactory;

public class BasicDungeon extends Dungeon {

	public BasicDungeon(Hero hero) {
		this.setDifficulty(0);

		int roomDim = 20;
		
		// create empty rooms
		Room room1 = new Room(roomDim, roomDim, "First Room", 1);
		Room room2 = new Room(roomDim, roomDim, "Second Room", 2);
		Room room3 = new Room(roomDim, roomDim, "Third Room", 3);
		
		// Add hero
		room1.addCharacter(hero, 0);
		
		// spawn monsters on the tiles
		
		// Room 1
		MonsterFactory.spawnBoar(room1.getTile(4));
		MonsterFactory.spawnSow(room1.getTile(1));
		MonsterFactory.spawnShoat(room1.getTile(2));
		
		// Room 2 
		MonsterFactory.spawnBoar(room2.getTile(2));
		MonsterFactory.spawnSow(room2.getTile(3));
		MonsterFactory.spawnShoat(room2.getTile(4));
		
		// Room 3
		MonsterFactory.spawnBoar(room3.getTile(3));
		MonsterFactory.spawnSow(room3.getTile(4));
		MonsterFactory.spawnShoat(room3.getTile(5));
		
		// Add rooms to dungeon
		
		this.setRooms(List.of(room1, room2, room3));
		
	}

	@Override
	public Dungeon clone() {
		return null;
	}

	@Override
	public Room getRoom(int level) {
		return this.getRooms().get(level);
	}

	
}
