package character;

import java.util.List;
import java.lang.Math;
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
		int hp = Math.floorDiv(getHP(), 2);
		int attack = Math.floorDiv(getAttack(), 2);
		int defense = Math.floorDiv(getDefense(), 2);
		int move = getMove()*2;
		
		Shoat s = new Shoat(0, hp, attack, defense, move);
		Shoat s2 = new Shoat(0, hp, attack, defense, move);
		return List.of(s, s2);
	}

}
