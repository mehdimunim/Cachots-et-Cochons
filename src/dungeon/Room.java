package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import character.Character;
import inventory.Item;

/**
 * A Room is a rectangle of tiles with meta-info (description and level in the
 * dungeon). Is built with a room builder
 */
public class Room implements Iterable<Tile>, Cloneable {

	/**
	 * List of rows of tiles so that tiles.get(x).get(y) return the tile at row x
	 * and column y
	 */
	private List<List<Tile>> tiles;
	private String description = "";
	private int level;

	/**
	 * Basic Room constructor. Fill the room with empty tiles
	 *
	 * @param x:     x dimension of the room
	 * @param y:     y dimension of the room
	 * @param desc:  description of the room
	 * @param level: level of the room in the dungeon
	 */
	public Room(int x, int y, String desc, int level) {

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

	/**
	 * Empty room constructor. Does not fill it with tiles
	 *
	 * @param desc:  description of the room
	 * @param level: level of the room in the dungeon
	 */
	public Room(String desc, int level) {
		description = desc;
		this.level = level;
		tiles = new ArrayList<List<Tile>>();
	}

	/**
	 * Add a character at the given index
	 *
	 * @param character
	 * @param index:    index = y*xDim + x if the character is added at Tile (x, y)
	 * @throws NonEmptyTileException
	 */
	public void addCharacter(character.Character character, int index) throws NonEmptyTileException {
		this.getTile(index).addCharacter(character);

	}

	/**
	 * Add a hero on the first tile
	 *
	 * @throws NonEmptyTileException
	 */
	public void addHero(character.Hero hero) throws NonEmptyTileException {
		getFirstTile().addCharacter(hero);
	}

	@Override
	public Room clone() {
		RoomBuilder rb = new RoomBuilder(description, level);
		for (Tile tile : this) {
			rb.addTile(tile.clone());
		}
		return rb.getRoom();
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

	/**
	 * Get all reachable tiles from a given reference within a circle. The distance
	 * is the Manhattan distance.
	 *
	 * @param refTile: reference tile
	 * @param move:    given range
	 * @return the list of all reachable tiles
	 */
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

	/**
	 * Get the tile containing a given character
	 *
	 * @param newChara
	 * @return tile
	 */
	public Tile getTile(Character newChara) {
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

	/**
	 * Get the x dimension of the room
	 *
	 * @return xDim
	 */
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

	/**
	 * Get the y dimension of the room
	 *
	 * @return yDim
	 */
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

}
