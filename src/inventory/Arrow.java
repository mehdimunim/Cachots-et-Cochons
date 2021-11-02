package inventory;

public class Arrow extends Item {
	int damage;
	
	public Arrow(int damage) {
		this.damage = damage;
	}
	public void damage(character.Character character) {
		character.loseHP(damage);
	}
	
	
}
