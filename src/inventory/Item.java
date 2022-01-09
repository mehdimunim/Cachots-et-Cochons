package inventory;

import character.Character;

public abstract class Item implements Cloneable {

	public void applyEffect(Character chara) {
	}

	public abstract String getFullDescription();

	public void removeEffect(Character chara) {
	}
	
	@Override
	public abstract Item clone();
}
