package inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * A default item factory
 *
 * @author Mehdi
 *
 */
public class DefaultItemFactory implements ItemFactoryInterface {

	@Override
	public Item createBow() {

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

	@Override
	public Item createDownStaircase() {
		return new Staircase("down");
	}

	@Override
	public Item createIronArrow() {
		Arrow arrow = new Arrow(10);
		return arrow;
	}

	@Override
	public Item createMagicalArrow() {
		Arrow arrow = new Arrow(20);
		return arrow;
	}

	@Override
	public Item createPotion() {
		Potion potion = new Potion(10);
		return potion;
	}

	@Override
	public Item createShield() {
		Shield shield = new Shield(10);
		return shield;
	}

	@Override
	public Item createSword() {
		Sword sword = new Sword(10);
		return sword;
	}

	@Override
	public Item createUpStaircase() {
		return new Staircase("up");
	}

	@Override
	public Item createWoodArrow() {
		Arrow arrow = new Arrow(1);
		return arrow;
	}

}
