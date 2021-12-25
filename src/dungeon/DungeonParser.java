package dungeon;

import inventory.Item;

import java.util.List;

import character.Character;
import character.Hero;
public class DungeonParser implements DungeonBuilder {

	
	private void createTile(int i, int j, Character chara, Item item) {
		
		Tile tile = new Tile(i, j);
		tile.addCharacter(chara);
		
	}
	
	@Override
	public void createRoom(int roomDim, int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void build() {
		// TODO Auto-generated method stub

	}

	@Override
	public Dungeon getDungeon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDifficulty(int difficulty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRooms(List<Room> rooms) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDifficulty() {
		// TODO Auto-generated method stub
		
	}

}
