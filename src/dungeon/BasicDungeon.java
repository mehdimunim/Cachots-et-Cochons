package dungeon;

import character.MonsterFactory;

public class BasicDungeon extends Dungeon {

	private BasicDungeon() {
		this.difficulty = 0;

		int roomDim = 20;
		
		// create empty rooms
		Room room1 = new Room(roomDim, roomDim, "First Room", 1);
		Room room2 = new Room(roomDim, roomDim, "Second Room", 2);
		Room room3 = new Room(roomDim, roomDim, "Third Room", 3);
		
		this.rooms.add(room1);
		this.rooms.add(room2);
		this.rooms.add(room3);


		// spawn monsters on the tiles
		
		// Room 1
		MonsterFactory.spawnBoar(room1.getTile(0));
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
		
	}

	@Override
	public Dungeon clone() {
		return new BasicDungeon();
	}

	@Override
	public Room getRoom(int level) {
		return this.rooms.get(level);
	}

	
}
