package inventory;

public class Sword extends Item{
	
	int damage;
	
	public Sword(int damage) {
		this.damage = damage;
	}
	
	public void addAttack(character.Character character) {
		
		character.gainAttack(damage);
		
	}

}
