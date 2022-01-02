package character;

public abstract class Character {
	
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
	};
	
	public void attack(Character character) {
		
	}

	public void loseHP(int loss) {
		this.HP -= loss;
	}
	
	public void gainHP(int gain) {
		this.HP += gain;
	}
	
	public void gainXP(int gain) {
		this.XP = gain;
	}
	
	public void gainAttack(int gain) {
		this.attack += gain;
	}
	
	public void loseAttack(int loss) {
		this.attack -= loss;
	}
	
	public void gainDefense(int gain) {
		this.defense +=gain;
	}
	
	public void loseDefense(int loss) {
		this.defense -= loss;
		
	}
	
	public int getXP() {
		return XP;
	}

	public void setXP(int xP) {
		XP = xP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public int getBowRange() {
		return this.bowRange;
	}

	public abstract boolean isEnnemyWith(Character chara);
	
	public boolean isDead() {
		return this.HP <= 0;
	}



}
