package character;

public class Hero extends Character{

	private Hero hero;
	
	private Hero(int HP, int XP, int attack, int defense, int move) {super(HP, XP, attack, defense, move);};
	
	
	public Hero createHero(int HP, int XP, int attack, int defense, int move) {
		
		if (this.hero == null) {
			this.hero = new Hero(HP, XP, attack, defense, move);
		}
		
		return this.hero;
	}
	public void useItem(inventory.Item item) {
		
	};
	
	@Override
	public String toString() {
		return "H";
	}


	public Hero getHero() {
		return hero;
	}


	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
