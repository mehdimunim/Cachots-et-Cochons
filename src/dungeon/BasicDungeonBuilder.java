package dungeon;

import character.MonsterFactory;

import java.util.List;

import character.Hero;

public class BasicDungeonBuilder implements DungeonBuilder {
private Dungeon dungeon = new BasicDungeon();
	
	public Dungeon getDungeon() {
		return dungeon;
	}
	
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
	
	@Override
	public void setDifficulty() {
		this.setDifficulty(0);
	}
	
	@Override
	public void createRoom(int roomDim, int level) {
		
		Room room = new Room(roomDim, roomDim, "Room " + level, level);
		
		// +1 because hero is already at tile 0
		// mod the size of the room
		MonsterFactory.spawnBoar(room.getTile(1+ level %roomDim*roomDim));
		MonsterFactory.spawnSow(room.getTile(2 + level %roomDim*roomDim));
		MonsterFactory.spawnShoat(room.getTile(3 + level %roomDim*roomDim));
		
		this.addRoom(room);
	}

	
	@Override
	public void build() {
		this.setDifficulty();
		for (int i=0; i<3; i++) {
			createRoom(10, i);
		}
		createAllRandomStaircases();
	}
			
		

}
