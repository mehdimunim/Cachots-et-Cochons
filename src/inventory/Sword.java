package inventory;

import character.Character;

public class Sword extends Item {

	private int damage;

	public Sword(int damage) {
		this.damage = damage;
	}

	public void addAttack(character.Character character) {

		character.gainAttack(damage);

	}

	@Override
	public void applyEffect(Character chara) {
		addAttack(chara);
	}

	@Override
	public Sword clone() {
		return new Sword(damage);
	}

	@Override
	public String getFullDescription() {
		return "Sword, damage: " + String.valueOf(damage);
	}

	@Override
	public void removeEffect(Character chara) {
		chara.loseAttack(damage);
	}

	@Override
	public String toString() {
		return "/";
	}

}
