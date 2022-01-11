package character;

/**
 * Monsters are the main antagonists of the Hero
 *
 * @author Mehdi
 *
 */
public abstract class Monster extends Character {

	public Monster(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
	}

	/**
	 * Monster are at war with Heros
	 */
	@Override
	public boolean isEnnemyWith(Character chara) {
		return chara instanceof Hero;
	}
}
