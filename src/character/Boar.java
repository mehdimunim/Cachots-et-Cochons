package character;

/**
 * Male adult pig
 */
public class Boar extends AdultPig {
	public Boar(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
	}

	@Override
	public Boar clone() {
		return new Boar(getXP(), getHP(), getAttack(), getDefense(), getMove());
	}

	@Override
	public String toString() {
		return "B";
	}

}