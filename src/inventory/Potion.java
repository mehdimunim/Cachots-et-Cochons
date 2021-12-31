package inventory;

public class Potion extends Item{
	private int HP; // health points
	
	public Potion(int HP) {
		this.HP = HP;
	}
	public void heal(character.Character character ) {
		character.gainHP(HP);
	}
	
	@Override
	public String toString() {
		return "+";
	}
	
	@Override
	public String getFullDescription() {
		return "Potion, HP: " + String.valueOf(HP);
	}
}
