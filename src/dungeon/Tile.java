package dungeon;

import java.util.Optional;

import inventory.Item;

public class Tile {

	private int xPosition;
	private int yPosition;
	private character.Character character;
	private inventory.Item item;

	public Tile(int XPosition, int YPosition) {
		this.xPosition = XPosition;
		this.yPosition = YPosition;
	}

	public Tile() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCharacter(character.Character newCharacter) {
		/**
		 * Add a character 
		 */
		if (this.character == null) {
			this.character = newCharacter;
		}
		
		// else conflict between newCharacter and character
		// else do nothing
	}
	
	public void removeCharacter() {
		this.character = null;
	}
	
	

	public void addItem(inventory.Item item) {
		this.item = item;
	}
	
	public void removeItem() {
		this.item = null;
	}

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Optional<character.Character> getCharacter() {
		if (this.character == null) {
			return Optional.empty();
		}
		return Optional.of(character);
	}

	public Optional<Item> getItem() {
		if (this.item == null) {
			return Optional.empty();
		}
		return Optional.of(this.item);
	}

	public int manhattanDistanceTo(Tile tile) {
		// Manhattan distance
		return Math.abs(tile.xPosition - xPosition) + Math.abs(tile.yPosition - yPosition);
	}
	
	public double euclidianDistanceTo(Tile tile) {
		// Euclidian distance
		return Math.sqrt(Math.pow(tile.xPosition - xPosition,2) + Math.pow(tile.yPosition - yPosition, 2));
	}
	
	public boolean hasCharacter() {
		return (this.character == null) ? false : true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			Tile otherTile = (Tile) o;
			return (otherTile.getXPosition() == xPosition && otherTile.getYPosition() == yPosition);
		}
		return false;
	}
	
	public String getDepiction() {
		/**
		 * Get the way the Tile has to be depicted
		 * Characters are displayed in priority
		 */
		if (this.item == null && this.character == null) {
			return " ";
		}
		else if (this.character == null) {
			return this.item.toString();
		}
		else {
			return this.character.toString();
		}
	}
	
	@Override
	public String toString() {
		return "(" + String.valueOf(xPosition) + "," + String.valueOf(yPosition) + ")";
	}

	public boolean isStaircase() {
		return false;
	}
}
