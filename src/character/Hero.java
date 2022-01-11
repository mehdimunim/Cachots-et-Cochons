package character;

import java.util.Optional;

import inventory.FullInventoryException;
import inventory.Inventory;
import inventory.Item;

/**
 * The Hero is played by humans. Implements singleton design pattern.
 *
 * @author Mehdi
 *
 */
public class Hero extends Character {

	private static Hero defaultHero;
	private static Hero hero;

	public static Hero createDefaultHero() {

		if (defaultHero == null) {
			defaultHero = new Hero(120, 80, 100, 100, 2, "PigSlaughter");
		}

		return defaultHero;
	}

	/**
	 *
	 * @param name
	 * @return A default hero with the given name
	 */
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

	private Inventory invent;

	private String name;

	private Hero(int HP, int XP, int attack, int defense, int move, String name) {
		super(HP, XP, attack, defense, move);
		this.name = name;
		// inventory with capacity of 3
		invent = new Inventory(3);
	}

	public void addItem(Item item) throws FullInventoryException {
		invent.addItem(item);
	}

	@Override
	public Hero clone() {
		Hero clonedHero = new Hero(getXP(), getHP(), getAttack(), getDefense(), getMove(), getName());
		// clone inventory
		invent.getItems().stream().forEachOrdered(it -> {
			try {
				clonedHero.addItem(it.clone());
			} catch (FullInventoryException e) {
				e.printStackTrace();
			}
		});
		return clonedHero;
	}

	public Inventory getInventory() {
		return invent;
	}

	public String getName() {
		return name;
	}

	@Override
	/**
	 * A Hero is at war with monsters
	 */
	public boolean isEnnemyWith(Character chara) {
		// Hero is at war with all characters
		return chara instanceof Monster;
	}

	/**
	 * Search a tile
	 *
	 * @param tile
	 * @return Optional of an item: the item of the tile if it exists
	 */
	public Optional<Item> searchTile(dungeon.Tile tile) {
		Optional<Item> item = tile.getItem();
		if (item.isPresent()) {
			try {
				invent.addItem(item.get());
			} catch (FullInventoryException e) {
				e.printStackTrace();
			}
			item.get().applyEffect(this);
			tile.removeItem();
		}
		return item;
	}

	@Override
	public String toString() {
		return "H";
	}

	public void useItem(Item item) {
		item.removeEffect(this);
		invent.removeItem(item);
	}

}
