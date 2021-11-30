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

		if (this.character == null) {
			this.character = newCharacter;
		}
		// else conflict between newCharacter and character
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
		return Math.abs(tile.xPosition - xPosition) + Math.abs(tile.xPosition - xPosition);
	}
	
	public double euclidianDistanceTo(Tile tile) {
		// Euclidian distance
		return Math.sqrt(Math.pow(tile.xPosition - xPosition,2) + Math.pow(tile.xPosition - xPosition, 2));
	}
	
	public boolean hasCharacter() {
		return (this.character == null) ? false : true;
	}

}
