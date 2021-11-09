package dungeon;

public class Tile {

	private int xPosition;
	private int yPosition;
	private character.Character character;
	private inventory.Item item;

	public Tile(int XPosition, int YPosition) {
		this.xPosition = XPosition;
		this.yPosition = YPosition;
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

	public character.Character getCharacter() {
		// attention si character null (cf. optionnels)
		// java.util.Optional
		// e.g:
		// tile.getCharacter().ifIsPresent(s -> s.addItem())
		return character;
	}

	public inventory.Item getItem() {
		return this.item;
	}

	public int manhattanDistanceTo(Tile tile) {
		// Manhattan distance
		return Math.abs(tile.xPosition - xPosition) + Math.abs(tile.xPosition - xPosition);
	}
	
	public double euclidianDistanceTo(Tile tile) {
		// Manhattan distance
		return Math.sqrt(Math.pow(tile.xPosition - xPosition,2) + Math.pow(tile.xPosition - xPosition, 2));
	}
	
	public boolean hasCharacter() {
		return (this.character == null) ? false : true;
	}

}
