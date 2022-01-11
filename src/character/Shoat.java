package character;

/**
 * A young, newly-weaned pig (piglet).
 *
 * @author Mehdi
 *
 */
public class Shoat extends Monster {

	public Shoat(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
	}

	@Override
	public Shoat clone() {
		return new Shoat(getXP(), getHP(), getAttack(), getDefense(), getMove());
	}

	public AdultPig grow() {
		return null;
	}

	/**
	 * Downcase for piglets and Uppercase for Sows
	 */
	@Override
	public String toString() {
		return "s";
	}
}
