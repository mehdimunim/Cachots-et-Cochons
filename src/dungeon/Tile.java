package dungeon;

public class Tile {
	
	int XPosition;
	int YPosition;
	Character character;
	inventory.Item item; 
	
	public void addCharacter(Character newCharacter) {
		
		this.character = newCharacter;
	}
	
	public void addItem(inventory.Item item) {
		this.item = item;
	}
	
	public int getXPosition() {
		return XPosition;
	}

	public void setXPosition(int xPosition) {
		XPosition = xPosition;
	}

	public int getYPosition() {
		return YPosition;
	}

	public void setYPosition(int yPosition) {
		YPosition = yPosition;
	}

	public Character getCharacter() {
		return character;
	}

	public inventory.Item getItem() {
		return this.item;
	}

}
