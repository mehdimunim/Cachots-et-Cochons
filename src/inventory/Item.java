package inventory;

import character.Character;

/**
 * Item abstract class representing object that can be used
 *
 * @author Mehdi
 *
 */
public abstract class Item implements Cloneable {

	public void applyEffect(Character chara) {
	}

	@Override
	public abstract Item clone();

	public abstract String getFullDescription();

	public void removeEffect(Character chara) {
	}
}
