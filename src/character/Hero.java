package character;

import java.util.Optional;

import inventory.Item;

public class Hero extends Character {

	private static Hero defaultHero;
	private static Hero hero;
	private inventory.Inventory invent;
	private String name;

	private Hero(int HP, int XP, int attack, int defense, int move, String name) {
		super(HP, XP, attack, defense, move);
		this.name = name;
		// inventory with capacity of 3
		this.invent = new inventory.Inventory(3);
	};

	public static Hero createDefaultHero() {

		if (defaultHero == null) {
			defaultHero = new Hero(120, 80, 100, 100, 2, "PigSlaughter");
		}

		return defaultHero;
	}

	public static Hero createHero(String name) {
		/**
		 * Personalized hero
		 */
		if (hero == null) {
			hero = new Hero(120, 80, 100, 100, 100, name);
		}

		else if (hero.name != name) {
			hero.name = name;
		}

		return hero;
	}

	public Optional<Item> searchTile(dungeon.Tile tile) {
		Optional<Item> item = tile.getItem();	
		item.ifPresent(it -> this.invent.addItem(it));
		return item;
	}

	public void addItem(inventory.Item item) {
		this.invent.addItem(item);
	}

	public void useItem(inventory.Item item) {
		this.invent.removeItem(item);
	};

	@Override
	public String toString() {
		return "H";
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean isEnnemyWith(Character chara) {
		// Hero is at war with all characters
		return chara instanceof Monster;
	}

}
