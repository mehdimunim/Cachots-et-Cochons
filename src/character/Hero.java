package character;

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

	public static Hero getDefaultHero() {

		if (defaultHero == null) {
			defaultHero = new Hero(120, 80, 100, 100, 100, "PigSlaughter");
		}

		return defaultHero;
	}

	public static Hero getHero(String name) {
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

	public inventory.Item searchTile(dungeon.Tile tile) {
		inventory.Item item = tile.getItem();

		if (item != null) {
			this.invent.addItem(item);
		}
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

}
