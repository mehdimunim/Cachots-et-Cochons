package dungeon;

import java.util.List;
import java.util.Random;

import character.Character;
import inventory.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Room implements Iterable<Tile> {
	/**
	 * A Room is a rectangle of tiles with metainfo (description and level in the
	 * dungeon)
	 */

	private List<List<Tile>> tiles; // list of rows of tiles
	private String description = "";
	private int level;

	public Room(String desc, int level) {
		/**
		 * Empty room constructor
		 * 
		 * @param desc:  description of the room
		 * @param level: level of the room in the dungeon
		 */
		this.description = desc;
		this.level = level;
		this.tiles = new ArrayList<List<Tile>>();
	}

	public Room(List<List<Tile>> tiles, String desc, int level) {
		this.description = desc;
		this.level = level;
		this.tiles = tiles;
	}

	public Room(int x, int y, String desc, int level) {
		/**
		 * Room constructor
		 * 
		 * @param x:     x dimension of the room
		 * @param y:     y dimension of the room
		 * @param desc:  description of the room
		 * @param level: level of the room in the dungeon
		 */
		this.description = desc;
		this.level = level;
		this.tiles = new ArrayList<List<Tile>>();
		for (int i = 1; i <= x; i++) {
			List<Tile> row = new ArrayList<>();
			for (int j = 1; j <= y; j++) {
				row.add(new Tile(i, j));
			}
			tiles.add(row);
		}

	}
	
	public List<Tile> getRow(int i) {
		return tiles.get(i-1);
	}

	public int getX() {
		if (tiles == null || tiles.isEmpty()) {
			return 0;
		}
		List<Integer> listXPositions = new ArrayList<>();
		for (Tile tile : this) {
			listXPositions.add(tile.getXPosition());
		}
		return Collections.max(listXPositions);
	}

	public int getY() {
		if (tiles == null || tiles.get(0).isEmpty()) {
			return 0;
		}
		List<Integer> listYPositions = new ArrayList<>();
		for (Tile tile : this) {
			listYPositions.add(tile.getYPosition());
		}
		return Collections.max(listYPositions);
	
	}

	public String getDescription() {
		return this.description;
	};

	public List<List<Tile>> getTiles() {
		return this.tiles;
	}

	public Tile getTile(int index) {
		// index = y*xDim + x
		int x = index % getX();
		int y = (index - x) / getX();
		return this.tiles.get(x).get(y);
	}

	public Tile getTile(int x, int y) {
		/*
		 * Tile positions start at (1,1)
		 */
		return this.tiles.get(x - 1).get(y - 1);
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
		return this.tiles.get(getX() - 1).get(getY() - 1);
	}

	public List<character.Character> getCharacters() {
		List<character.Character> charas = new ArrayList<character.Character>();
		for (Tile tile : this)
			tile.getCharacter().ifPresent(ch -> charas.add(ch));
		return charas;
	}

	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		for (Tile tile : this)
			tile.getItem().ifPresent(it -> items.add(it));
		return items;
	}

	public List<Tile> getReachableTilesFrom(Tile refTile, int move) {
		List<Tile> res = new ArrayList<Tile>();

		// add tiles within range
		for (Tile tile : this) {
			if (refTile.manhattanDistanceTo(tile) <= move) {
				res.add(tile);
			}
			// remove reference tile
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

	public void setTile(Tile tile) {
		int x = tile.getXPosition();
		int y = tile.getYPosition();

		this.tiles.get(x).set(y, tile);

	}
	

	public Tile getRandomTile() {
		Random rand = new Random();
		return getTile(rand.nextInt(tiles.size()));
	}

}
