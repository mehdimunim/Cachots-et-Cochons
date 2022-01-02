package inventory;

import character.Character;

public abstract class Item {

	public abstract String getFullDescription();
	
	public void applyEffect(Character chara) {};
	
	public void removeEffect(Character chara) {};
}
