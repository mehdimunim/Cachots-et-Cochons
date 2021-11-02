package inventory;

public class Shield extends Item{
	int defense;
	
	public Shield(int defense) {
		this.defense = defense;
	}
	
	public void addDefense(character.Character character) {
		
		character.gainDefense(defense);
	}
}