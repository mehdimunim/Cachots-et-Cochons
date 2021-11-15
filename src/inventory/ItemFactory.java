package inventory;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {
	
	public Item spawnWoodArrow(dungeon.Tile tile) {
		Arrow arrow = new Arrow(1);
		tile.addItem(arrow);
		return arrow;
	}
	
	public Item spawnIronArrow(dungeon.Tile tile) {
		Arrow arrow = new Arrow(10);
		tile.addItem(arrow);
		return arrow;
	}
	
	public Item spawnMagicalArrow(dungeon.Tile tile) {
		Arrow arrow = new Arrow(20);
		tile.addItem(arrow);
		return arrow;
	}
	
	public Item spawnBow(dungeon.Tile tile) {
		
		List<Arrow> quiver = new ArrayList<>();
		
		Arrow woodArrow1 = new Arrow(1); 
		Arrow woodArrow2 = new Arrow(1);
		Arrow woodArrow3 = new Arrow(1);
		
		quiver.add(woodArrow1);
		quiver.add(woodArrow2);
		quiver.add(woodArrow3);
		
		Bow bow = new Bow(5, quiver);
		
		tile.addItem(bow);
		return bow;
	}
	
	public Item spawnSword(dungeon.Tile tile) {
		Sword sword = new Sword(10);
		tile.addItem(sword);
		return sword;
	}
	
	public Item spawnShield(dungeon.Tile tile) {
		Shield shield = new Shield(10);
		tile.addItem(shield);
		return shield;	
	}
	
	public Item spawnPotion(dungeon.Tile tile) {
		Potion potion = new Potion(10);
		tile.addItem(potion);
		return potion;
	}

}
