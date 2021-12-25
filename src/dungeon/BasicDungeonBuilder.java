package dungeon;

import character.MonsterFactory;
import character.Hero;

public class BasicDungeonBuilder extends DungeonBuilder {
	
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
