package inventory;

import character.Character;

public abstract class Item {

	public void applyEffect(Character chara) {
	}

	public abstract String getFullDescription();

	public void removeEffect(Character chara) {
	}
}
