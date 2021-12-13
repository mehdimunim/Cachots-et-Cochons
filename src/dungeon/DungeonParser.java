package dungeon;

import inventory.Item;
import character.Character;
public class DungeonParser extends DungeonBuilder {

	
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

}
