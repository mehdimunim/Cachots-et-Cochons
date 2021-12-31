package inventory;

public class Shield extends Item{
	private int defense;
	
	public Shield(int defense) {
		this.defense = defense;
	}
	
	public void addDefense(character.Character character) {
		
		character.gainDefense(defense);
	}
	
	@Override
	public String toString() {
		return "#";
	}
	
	@Override
	public String getFullDescription() {
		return "Shield, defense: " + String.valueOf(defense);
	}
}
