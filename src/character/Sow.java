package character;

import java.util.List;

/**
 * Female adult pig
 *
 * @author Mehdi
 *
 */
public class Sow extends AdultPig {

	public Sow(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
	}

	@Override
	public Sow clone() {
		return new Sow(getXP(), getHP(), getAttack(), getDefense(), getMove());
	}

	/**
	 * The sow gives birth to shoats
	 *
	 * @param boar: male adult pig
	 * @return a list of shoats
	 */
	public List<Shoat> farrow(Boar boar) {
		int hp = Math.floorDiv(getHP(), 2);
		int attack = Math.floorDiv(getAttack(), 2);
		int defense = Math.floorDiv(getDefense(), 2);
		int move = getMove() * 2;

		Shoat s = new Shoat(0, hp, attack, defense, move);
		Shoat s2 = new Shoat(0, hp, attack, defense, move);
		return List.of(s, s2);
	}

	@Override
	public String toString() {
		return "S";
	}

}
