package dungeon;

public class Tile {

	int xPosition;
	int yPosition;
	character.Character character;
	inventory.Item item;

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

	public void addItem(inventory.Item item) {
		this.item = item;
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
		return character;
	}

	public inventory.Item getItem() {
		return this.item;
	}

}
