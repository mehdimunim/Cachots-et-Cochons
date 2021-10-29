package inventory;

public class Potion extends Item{
	int HP;
	
	public void heal(character.Character character ) {
		character.gainHP(HP);
	}

}
