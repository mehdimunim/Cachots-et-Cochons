package inventory;

public class Arrow extends Item {
	int damage;
	
	public void damage(character.Character character) {
		character.loseHP(damage);
	}
	
	
}
