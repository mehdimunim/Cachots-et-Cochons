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
		
		this.character = newCharacter;
	}
	
	public void addItem(inventory.Item item) {
		this.item = item;
	}
	
	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		xPosition = xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		yPosition = yPosition;
	}

	public character.Character getCharacter() {
		return character;
	}

	public inventory.Item getItem() {
		return this.item;
	}

}
