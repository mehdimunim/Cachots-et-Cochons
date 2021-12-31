package inventory;

public class Sword extends Item{
	
	private int damage;
	
	public Sword(int damage) {
		this.damage = damage;
	}
	
	public void addAttack(character.Character character) {
		
		character.gainAttack(damage);
		
	}
	
	@Override
	public String toString() {
		return "/";
	}
	
	@Override
	public String getFullDescription() {
		return "Sword, damage: " + String.valueOf(damage);
	}

}
