package inventory;

/**
 * Factory interface (see Factory Design Pattern).
 *
 * @author Mehdi
 *
 */
public interface ItemFactoryInterface {

	Item createBow();

	Item createDownStaircase();

	Item createIronArrow();

	Item createMagicalArrow();

	Item createPotion();

	Item createShield();

	Item createSword();

	Item createUpStaircase();

	Item createWoodArrow();

}
