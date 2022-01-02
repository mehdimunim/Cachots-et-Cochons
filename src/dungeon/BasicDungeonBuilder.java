package dungeon;

import java.util.List;

import character.Hero;
import character.MonsterFactory;
import inventory.DefaultItemFactory;

public class BasicDungeonBuilder implements DungeonBuilder {
private Dungeon dungeon = new BasicDungeon();
	
	public Dungeon getDungeon() {
		return dungeon;
	}
	
	public void setDifficulty(int difficulty) {
		dungeon.setDifficulty(difficulty);
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
	
	public void addStaircase(Room downRoom, Room upRoom, int i, int j) {
		downRoom.getTile(i, j).addItem(DefaultItemFactory.createDownStaircase());
		upRoom.getTile(i, j).addItem(DefaultItemFactory.createUpStaircase());
	}
	@Override
	public void createRoom(int roomDim, int level) {
		
		Room room = new Room(roomDim, roomDim, "Room " + level, level);
		MonsterFactory fac = new MonsterFactory();
		// fill the room
		// fill with monsters
		// +1 because hero is already at tile 0
		// mod the size of the room
		fac.spawnBoar(room.getTile(1+ level %roomDim*roomDim));
		fac.spawnSow(room.getTile(2 + level %roomDim*roomDim));
		fac.spawnShoat(room.getTile(3 + level %roomDim*roomDim));
		
		// fill with items
		room.getTile(1+ level %roomDim*roomDim).addItem(DefaultItemFactory.createIronArrow());
		room.getTile(5+ level %roomDim*roomDim).addItem(DefaultItemFactory.createBow());
		room.getTile(6+ level %roomDim*roomDim).addItem(DefaultItemFactory.createShield());
		room.getTile(10+ level %roomDim*roomDim).addItem(DefaultItemFactory.createSword());
		
		this.addRoom(room);
	}

	
	@Override
	public void build() {
		this.setDifficulty();
		for (int i=0; i<3; i++) {
			createRoom(10, i);
		}
		addStaircase(this.dungeon.getRoom(0), this.dungeon.getRoom(1), 1, 2);
	}
			
		

}
