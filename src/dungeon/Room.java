package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import character.Character;
import inventory.Item;

public class Room implements Iterable<Tile>, Cloneable {
	/**
	 * A Room is a rectangle of tiles with metainfo (description and level in the
	 * dungeon)
	 */

	private List<List<Tile>> tiles; // list of rows of tiles
	private String description = "";
	private int level;

	public Room(int x, int y, String desc, int level) {
		/**
		 * Room constructor
		 *
		 * @param x:     x dimension of the room
		 * @param y:     y dimension of the room
		 * @param desc:  description of the room
		 * @param level: level of the room in the dungeon
		 */
		description = desc;
		this.level = level;
		tiles = new ArrayList<List<Tile>>();
		for (int i = 1; i <= x; i++) {
			List<Tile> row = new ArrayList<>();
			for (int j = 1; j <= y; j++) {
				row.add(new Tile(i, j));
			}
			tiles.add(row);
		}

	}

	public Room(List<List<Tile>> tiles, String desc, int level) {
		description = desc;
		this.level = level;
		this.tiles = tiles;
	}

	public Room(String desc, int level) {
		/**
		 * Empty room constructor
		 *
		 * @param desc:  description of the room
		 * @param level: level of the room in the dungeon
		 */
		description = desc;
		this.level = level;
		tiles = new ArrayList<List<Tile>>();
	}

	public void addCharacter(character.Character character, int index) {
		this.getTile(index).addCharacter(character);

	}

	public void addHero(character.Hero hero) {
		/**
		 * Add a hero on the first tile
		 */
		getFirstTile().addCharacter(hero);
	}

	public List<character.Character> getCharacters() {
		List<character.Character> charas = new ArrayList<character.Character>();
		for (Tile tile : this)
			tile.getCharacter().ifPresent(ch -> charas.add(ch));
		return charas;
	}

	public String getDescription() {
		return description;
	}

	public Tile getFirstTile() {
		return tiles.get(0).get(0);
	}

	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		for (Tile tile : this)
			tile.getItem().ifPresent(it -> items.add(it));
		return items;
	}

	public Tile getLastTile() {
		return tiles.get(getX() - 1).get(getY() - 1);
	}

	public int getLevel() {
		return level;
	}

	public Tile getRandomTile() {
		Random rand = new Random();
		return getTile(rand.nextInt(tiles.size()));
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

	public List<Tile> getRow(int i) {
		return tiles.get(i - 1);
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

	public Tile getTile(int index) {
		// index = y*xDim + x
		int x = index % getX();
		int y = (index - x) / getX();
		return tiles.get(x).get(y);
	}

	public Tile getTile(int x, int y) {
		/*
		 * Tile positions start at (1,1)
		 */
		return tiles.get(x - 1).get(y - 1);
	}

	public List<List<Tile>> getTiles() {
		return tiles;
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

	@Override
	public Iterator<Tile> iterator() {
		List<Tile> flattenRoom = new ArrayList<Tile>();
		for (List<Tile> row : tiles) {
			flattenRoom.addAll(row);
		}
		return flattenRoom.iterator();
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setTile(Tile tile) {
		int x = tile.getXPosition();
		int y = tile.getYPosition();

		tiles.get(x).set(y, tile);

	}
	
	@Override
	public Room clone() {
		RoomBuilder rb = new RoomBuilder(description, level);
		for (Tile tile : this) {
			rb.addTile(tile.clone());
		}
		return rb.getRoom();
	}

}
