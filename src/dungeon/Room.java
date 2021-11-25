package dungeon;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Room implements Iterable<Tile> {

	// mettre sous forme de matrice
	// potentiel Linked List
	// mettre un itérateur
	private Tile[][] tiles;
	private String description = "";
	private int xDim;
	private int yDim;
	private int level;

	public Room(int x, int y, String desc, int level) {
		this.description = desc;
		this.xDim = x;
		this.yDim = y;
		this.level = level;
		this.tiles = new Tile[x][y];
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

	public Object getTiles() {
		return this.tiles;
	}

	public Tile getTile(int index) {
		// index = y*xDim + x
		int x = index % xDim;
		int y = (index - x) / xDim;
		return this.getTile(x, y);
	}

	public Tile getTile(int x, int y) {

		return this.tiles[x][y];
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

	private Tile getFirstTile() {
		return this.tiles[0][0];
	}

	public List<character.Character> getCharacters() {
		var charas = new ArrayList<character.Character>();
		for (Tile tile : this)
			tile.getCharacter().ifPresent(ch -> charas.add(ch));
		return charas;
	}
	
	public List<Tile> getReachableTilesFrom(Tile refTile, int move) {		
		var res = new ArrayList<Tile>();
		
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
		return new Iterator<Tile>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < xDim * yDim;
			}

			@Override
			public Tile next() {
				currentIndex++;
				int x = currentIndex % xDim;
				int y = (currentIndex - currentIndex) / yDim;
				return tiles[x][y];
			}
		}

		;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

}
