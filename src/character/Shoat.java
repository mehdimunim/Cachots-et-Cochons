package character;

public class Shoat extends Monster {
	/*
	 * Young, newly-weaned pig
	 */

	public Shoat(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
		// TODO Auto-generated constructor stub
	}

	public AdultPig grow() {
		return null;
	}

	@Override
	public String toString() {
		// Uppercase for Sow
		return "s";
	}
	
	@Override
	public Shoat clone() {
		return new Shoat(getXP(), getHP(), getAttack(), getDefense(), getMove());
	}
}
