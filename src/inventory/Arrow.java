package inventory;

/**
 * An arrow with a given damage
 *
 * @author Mehdi
 *
 */
public class Arrow extends Item {
	private int damage;

	public Arrow(int damage) {
		this.damage = damage;
	}

	@Override
	public Arrow clone() {
		return new Arrow(damage);
	}

	public void damage(character.Character character) {
		character.loseHP(damage);
	}

	@Override
	public String getFullDescription() {
		return "Arrow, damage: " + String.valueOf(damage);
	}

	@Override
	public String toString() {
		return "-";
	}

}
