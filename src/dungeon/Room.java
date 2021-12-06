package dungeon;

import java.util.List;

import character.Character;

import java.util.ArrayList;
import java.util.Iterator;

public class Room implements Iterable<Tile> {

	private List<List<Tile>> tiles;
	private String description = "";
	private int xDim;
	private int yDim;
	private int level;

	public Room(int x, int y, String desc, int level) {
		this.description = desc;
		this.xDim = x;
		this.yDim = y;
		this.level = level;
		this.tiles = new ArrayList<List<Tile>>();
		for (int i = 0; i<xDim;i++) {
			List<Tile> row = new ArrayList<>();
			for (int j = 0; j<yDim;j++) {
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
		var flattenRoom = new ArrayList<Tile>();
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

	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
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

}
