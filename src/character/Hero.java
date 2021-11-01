package character;

public class Hero extends Character{

	private static Hero defaultHero;
	private static Hero hero;
	private String name;
	
	private Hero(int HP, int XP, int attack, int defense, int move, String name) {
		super(HP, XP, attack, defense, move);
		this.name = name;
	};
	
	
	public static Hero getDefaultHero() {
		
		if (defaultHero == null) {
			defaultHero = new Hero(120, 80, 100, 100, 100, "PigSlayer");
		}
		
		return defaultHero;
	}
	
public static Hero getHero(String name) {
		
		if (hero == null) {
			hero = new Hero(120, 80, 100, 100, 100, name);
		}
		
		else if (hero.name != name) {
			hero.name = name;
		}
		
		return hero;
	}
	
	
	public void useItem(inventory.Item item) {
		
	};
	
	@Override
	public String toString() {
		return "H";
	}


	public String getName() {
		return this.name;
	}
	
	
}
