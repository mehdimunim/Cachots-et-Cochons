package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {

	List<Tile> tiles = new ArrayList<Tile>();
	private String description = "";
	int xDim;
	int yDim;
	int level;

	public Room(int x, int y, String desc, int level) {
		this.description = desc;
		this.xDim = x;
		this.yDim = y;
		this.level = level;

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				Tile tile = new Tile(i, j);
				tiles.add(tile);
			}
		}
	}

	public int getX() {
		return this.xDim;
	}

	public int getY() {
		return this.yDim;
	}

	public String getDescription() {
		return this.description;
	};

	public List<Tile> getTiles() {
		return this.tiles;
	}
	
	public List<character.Character> getCharacters() {
		
		return this.tiles.stream().map(x -> x.getCharacter()).filter(s -> s!=null).collect(Collectors.toList());
	}

}