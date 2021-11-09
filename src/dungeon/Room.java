package dungeon;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.LinkedList;

public class Room implements Iterable<Tile>{

	// mettre sous forme de matrice
	// potentiel Linked List
	// mettre un itérateur
	private LinkedList<Tile> tiles = new LinkedList<Tile>();
	private String description = "";
	private int xDim;
	private int yDim;
	private int level;

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

	public Tile getTile(int index) {
		return this.tiles.get(index);
	}

	public Tile getTile(int x, int y) {

		/*
		 * 1 2 3 4 1* * * * 2* * * *
		 */
		// return this.getTile(xDim*(x-1) + y);
		return null;
	}

	public int getLevel() {
		return this.getLevel();
	}

	public void addCharacter(character.Character character, int index) {
		this.tiles.get(index).addCharacter(character);

	}

	public void addHero(character.Hero hero) {
		/**
		 * Add a hero on the first tile
		 */
		this.tiles.get(0).addCharacter(hero);
	}

	public List<character.Character> getCharacters() {

		return this.tiles.stream().map(x -> x.getCharacter()).filter(s -> s != null).collect(Collectors.toList());
	}

	@Override
	public Iterator<Tile> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
