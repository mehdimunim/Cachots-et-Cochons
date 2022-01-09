package dungeon;

import java.util.Optional;

import inventory.Item;
import inventory.Staircase;

public class Tile implements Comparable<Tile>, Cloneable {

	private int xPosition;
	private int yPosition;
	private character.Character character;
	private inventory.Item item;

	public Tile(int XPosition, int YPosition) {
		xPosition = XPosition;
		yPosition = YPosition;
	}

	public void addCharacter(character.Character newCharacter) {
		/**
		 * Add a character
		 */
		if (character == null) {
			character = newCharacter;
		}

		// else conflict between newCharacter and character
		// else do nothing
	}

	public void addItem(inventory.Item item) {
		this.item = item;
	}

	@Override
	public int compareTo(Tile otherTile) {
		if (xPosition == otherTile.getXPosition()) {
			return yPosition - otherTile.getYPosition();
		} else {
			return xPosition - otherTile.getXPosition();
		}

	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			Tile otherTile = (Tile) o;
			return (otherTile.getXPosition() == xPosition && otherTile.getYPosition() == yPosition);
		}
		return false;
	}

	public double euclidianDistanceTo(Tile tile) {
		// Euclidian distance
		return Math.sqrt(Math.pow(tile.xPosition - xPosition, 2) + Math.pow(tile.yPosition - yPosition, 2));
	}

	public Optional<character.Character> getCharacter() {
		if (character == null) {
			return Optional.empty();
		}
		return Optional.of(character);
	}

	public String getDepiction() {
		/**
		 * Get the way the Tile has to be depicted Characters are displayed in priority
		 */
		if (item == null && character == null) {
			return " ";
		} else if (character == null) {
			return item.toString();
		} else {
			return character.toString();
		}
	}

	public Optional<Item> getItem() {
		if (item == null) {
			return Optional.empty();
		}
		return Optional.of(item);
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public boolean hasCharacter() {
		return (character == null) ? false : true;
	}

	public boolean hasItem() {
		return (item == null) ? false : true;
	}

	public boolean isStaircase() {
		return item instanceof Staircase;
	}

	public int manhattanDistanceTo(Tile tile) {
		// Manhattan distance
		return Math.abs(tile.xPosition - xPosition) + Math.abs(tile.yPosition - yPosition);
	}

	public void removeCharacter() {
		character = null;
	}

	public void removeItem() {
		if (!isStaircase()) {
			item = null;
		}
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	@Override
	public String toString() {
		return "(" + String.valueOf(xPosition) + "," + String.valueOf(yPosition) + ")";
	}
	
	@Override
	public Tile clone() {
		Tile clonedTile = new Tile(xPosition, yPosition);
		if (character != null) clonedTile.addCharacter(character.clone());
		if (item != null) clonedTile.addItem(item.clone());
		return clonedTile;
	}
}
