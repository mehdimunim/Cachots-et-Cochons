package character;

public abstract class Monster extends Character {

	public Monster(int XP, int HP, int attack, int defense, int move) {
		super(XP, HP, attack, defense, move);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEnnemyWith(Character chara) {
		return chara instanceof Hero;
	}
}
