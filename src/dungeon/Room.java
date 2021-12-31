package dungeon;

import java.util.List;
import java.util.Random;

import character.Character;

import java.util.ArrayList;
import java.util.Iterator;

public class Room implements Iterable<Tile> {

	private List<List<Tile>> tiles;
	private String description = "";
	private int xDim;
	private int yDim;
	private int level;
	
	
	public Room(String desc, int level ) {
		/**
		 * Empty room constructor
		 * @param desc: description of the room
		 * @param level: level of the room in the dungeon
		 */
		this.description = desc;
		this.level = level;
		this.tiles = new ArrayList<List<Tile>>();
		this.xDim = 0;
		this.yDim = 0;
	}
	public Room(int x, int y, String desc, int level) {
		/**
		 * Room constructor
		 * @param x: x dimension of the room
		 * @param y: y dimension of the room
		 * @param desc: description of the room
		 * @param level: level of the room in the dungeon
		 */
		this.description = desc;
		this.xDim = x;
		this.yDim = y;
		this.level = level;
		this.tiles = new ArrayList<List<Tile>>();
		for (int i = 1; i<=xDim;i++) {
			List<Tile> row = new ArrayList<>();
			for (int j = 1; j<=yDim;j++) {
				row.add(new Tile(i, j));
			}
			tiles.add(row);
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

	public List<List<Tile>> getTiles() {
		return this.tiles;
	}

	public Tile getTile(int index) {
		// index = y*xDim + x
		int x = index % xDim;
		int y = (index - x) / xDim;
		return this.getTile(x, y);
	}

	public Tile getTile(int x, int y) {

		return this.tiles.get(x).get(y);
	}

	public void addCharacter(character.Character character, int index) {
		this.getTile(index).addCharacter(character);

	}

	public void addHero(character.Hero hero) {
		/**
		 * Add a hero on the first tile
		 */
		this.getFirstTile().addCharacter(hero);
	}

	public Tile getFirstTile() {
		return this.tiles.get(0).get(0);
	}
	
	public Tile getLastTile() {
		return this.tiles.get(xDim).get(yDim);
	}

	public List<character.Character> getCharacters() {
		List<character.Character> charas = new ArrayList<character.Character>();
		for (Tile tile : this)
			tile.getCharacter().ifPresent(ch -> charas.add(ch));
		return charas;
	}
	
	public List<Tile> getReachableTilesFrom(Tile refTile, int move) {		
		List<Tile> res = new ArrayList<Tile>();
		
		// add tiles within range
		for (Tile tile:this) {
			if (refTile.manhattanDistanceTo(tile) <= move) {
				res.add(tile);
			}
		//remove reference tile
		res.remove(refTile);
			
		}
		
		
		
		return res;
		
	}

	@Override
	public Iterator<Tile> iterator() {
		List<Tile> flattenRoom = new ArrayList<Tile>();
		for (List<Tile> row : tiles) {
			flattenRoom.addAll(row);
		}
		return flattenRoom.iterator();
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public Tile getTile(Character newChara) {
		// get the tile containing newChara
		for (Tile tile : this) {
			if (tile.getCharacter().isPresent() && tile.getCharacter().get() == newChara) {
				return tile;
			}
		}
		return null;
	}

	public Tile getRandomTile() {
		Random rand = new Random();
        return getTile(rand.nextInt(tiles.size()));
	}
	

}
