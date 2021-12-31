package inventory;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemFactory {
	
	public static Item createWoodArrow() {
		Arrow arrow = new Arrow(1);
		return arrow;
	}
	
	public static Item createIronArrow() {
		Arrow arrow = new Arrow(10);
		return arrow;
	}
	
	public static Item createMagicalArrow() {
		Arrow arrow = new Arrow(20);
		return arrow;
	}
	
	public static Item createBow() {
		
		List<Arrow> quiver = new ArrayList<>();
		
		Arrow woodArrow1 = new Arrow(1); 
		Arrow woodArrow2 = new Arrow(1);
		Arrow woodArrow3 = new Arrow(1);
		
		quiver.add(woodArrow1);
		quiver.add(woodArrow2);
		quiver.add(woodArrow3);
		
		Bow bow = new Bow(5, quiver);
		
		return bow;
	}
	
	public static Item createSword() {
		Sword sword = new Sword(10);
		return sword;
	}
	
	public static Item createShield() {
		Shield shield = new Shield(10);
		return shield;	
	}
	
	public  static Item createPotion() {
		Potion potion = new Potion(10);
		return potion;
	}
	
	public static Item createUpStaircase() {
		return new Staircase("up");	
	}
	
	public static Item createDownStaircase() {
		return new Staircase("down");
	}

}
