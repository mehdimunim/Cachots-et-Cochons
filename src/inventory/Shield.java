package inventory;

import character.Character;

public class Shield extends Item {
	private int defense;

	public Shield(int defense) {
		this.defense = defense;
	}

	public void addDefense(character.Character character) {

		character.gainDefense(defense);
	}

	@Override
	public void applyEffect(Character chara) {
		addDefense(chara);
	}

	@Override
	public String getFullDescription() {
		return "Shield, defense: " + String.valueOf(defense);
	}

	@Override
	public void removeEffect(Character chara) {
		chara.loseDefense(defense);
	}

	@Override
	public String toString() {
		return "#";
	}
}
