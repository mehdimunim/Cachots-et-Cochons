package inventory;

import character.Character;

public class Potion extends Item {
	private int HP; // health points

	public Potion(int HP) {
		this.HP = HP;
	}

	@Override
	public void applyEffect(Character chara) {
		heal(chara);
	}

	@Override
	public String getFullDescription() {
		return "Potion, HP: " + String.valueOf(HP);
	}

	public void heal(character.Character character) {
		character.gainHP(HP);
	}

	@Override
	public void removeEffect(Character chara) {
		chara.loseHP(HP);
	}

	@Override
	public String toString() {
		return "+";
	}
}
