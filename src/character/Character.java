package character;

/**
 * A character includes the main hero, monsters and unarmed characters
 * (merchants, etc.)
 *
 * @author Mehdi
 *
 */
public abstract class Character implements Cloneable {

	/**
	 *
	 * XP: Character experience
	 * HP: health point
	 */
	private int XP;
	private int HP;
	private int attack;
	private int defense;
	private int move;
	private int bowRange;

	public Character(int XP, int HP, int attack, int defense, int move) {

		this.XP = XP;
		this.HP = HP;
		this.attack = attack;
		this.defense = defense;
		this.move = move;
	}

	@Override
	public abstract Character clone();

	public void gainAttack(int gain) {
		attack += gain;
	}

	public void gainDefense(int gain) {
		defense += gain;
	}

	public void gainHP(int gain) {
		HP += gain;
	}

	public void gainXP(int gain) {
		XP = gain;
	}

	public int getAttack() {
		return attack;
	}

	public int getBowRange() {
		return bowRange;
	}

	public int getDefense() {
		return defense;
	}

	public int getHP() {
		return HP;
	}

	public int getMove() {
		return move;
	}

	public int getXP() {
		return XP;
	}

	public boolean isDead() {
		return HP <= 0;
	}

	public abstract boolean isEnnemyWith(Character chara);

	public void loseAttack(int loss) {
		attack -= loss;
	}

	public void loseDefense(int loss) {
		defense -= loss;

	}

	public void loseHP(int loss) {
		HP -= loss;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public void setXP(int xP) {
		XP = xP;
	}

}
