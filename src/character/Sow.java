package character;

import java.util.List;

public class Sow extends AdultPig {
	
	/*
	 * Female adult pig
	 */

	public Sow(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "S";
	}
	
	public List<Shoat> farrow(Boar boar) {
		return null;
	}

}
