package inventory;

public class Potion extends Item{
	int HP; // health points
	
	public Potion(int HP) {
		this.HP = HP;
	}
	public void heal(character.Character character ) {
		character.gainHP(HP);
	}

}
