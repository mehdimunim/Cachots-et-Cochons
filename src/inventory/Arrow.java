package inventory;

public class Arrow extends Item {
	private int damage;
	
	public Arrow(int damage) {
		this.damage = damage;
	}
	public void damage(character.Character character) {
		character.loseHP(damage);
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
	@Override
	public String getFullDescription() {
		return "Arrow, damage: " + String.valueOf(damage);
	}
	
}
