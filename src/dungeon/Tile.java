package dungeon;

import java.util.Optional;

import inventory.Item;
import inventory.Staircase;

/**
 * A tile is the component of a room. A tile can contains at most one character
 * and one item
 *
 * @author Mehdi
 *
 */
public class Tile implements Comparable<Tile>, Cloneable {

	/**
	 * x and y positions are the position of the tile in the room
	 */
	private int xPosition;
	private int yPosition;
	private character.Character character;
	private inventory.Item item;

	public Tile(int XPosition, int YPosition) {
		xPosition = XPosition;
		yPosition = YPosition;
	}

	/**
	 * Add a character
	 *
	 * @param newCharacter
	 * @throws NonEmptyTileException when the tile is
	 */
	public void addCharacter(character.Character newCharacter) throws NonEmptyTileException {
		if (character == null) {
			character = newCharacter;
		} else {
			throw new NonEmptyTileException("The tile already has a character");
		}
	}

	public void addItem(inventory.Item newItem) throws NonEmptyTileException {
		if (item == null) {
			item = newItem;
		} else {
			throw new NonEmptyTileException("The tile already has an item");
		}
	}

	@Override
	public Tile clone() {
		Tile clonedTile = new Tile(xPosition, yPosition);
		if (character != null)
			try {
				clonedTile.addCharacter(character.clone());
			} catch (NonEmptyTileException e) {
				e.printStackTrace();
			}
		if (item != null)
			try {
				clonedTile.addItem(item.clone());
			} catch (NonEmptyTileException e) {
				e.printStackTrace();
			}
		return clonedTile;
	}

	/**
	 * A tile is "bigger" than another if its xPosition is greater or if equal, if
	 * the yPosition is greater.
	 *
	 */
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

	/**
	 * Euclidian distance between tiles
	 *
	 * @param tile
	 * @return positive integer
	 */
	public double euclidianDistanceTo(Tile tile) {
		return Math.sqrt(Math.pow(tile.xPosition - xPosition, 2) + Math.pow(tile.yPosition - yPosition, 2));
	}

	public Optional<character.Character> getCharacter() {
		if (character == null) {
			return Optional.empty();
		}
		return Optional.of(character);
	}

	/**
	 * Get the way the tile has to be depicted Characters are displayed in priority
	 */
	public String getDepiction() {
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

	/**
	 * Manhattan distance between tiles
	 *
	 * @param tile
	 * @return a positive integer
	 */
	public int manhattanDistanceTo(Tile tile) {
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
}
