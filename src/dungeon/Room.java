package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {

	List<Tile> tiles = new ArrayList<Tile>();
	private String description = "";
	int x;
	int y;

	public Room(int x, int y, String desc) {
		this.description = desc;
		this.x = x;
		this.y = y;

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				Tile tile = new Tile(i, j);
				tiles.add(tile);
			}
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
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
