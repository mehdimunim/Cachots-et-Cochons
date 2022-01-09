package character;

public class Boar extends AdultPig {
	/*
	 * Male adult pig
	 */
	public Boar(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public Boar clone() {
		return new Boar(getXP(), getHP(), getAttack(), getDefense(), getMove());
	}
	
}