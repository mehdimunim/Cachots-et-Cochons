package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import character.Character;
import character.Hero;
import dungeon.BasicDungeonBuilder;
import dungeon.Dungeon;
import dungeon.Tile;
import main.AIPlayer;
import main.HumanPlayer;

class AttackTest {
	private Dungeon dungeon;
	private AIPlayer ai;
	private HumanPlayer human;
	
	void initDungeon() {
		// create Hero
		Hero myHero = Hero.createDefaultHero();
				
		// build dungeon with Hero
		var builder = new BasicDungeonBuilder();
		builder.build();
				
		// add Hero on the first Tile of the First Room
		builder.addHero(myHero);
				
		dungeon = builder.getDungeon();
				
	}
	void initAI() {
		Character chara = dungeon.getRoom(0).getCharacters().get(1);
		Tile tileChara = dungeon.getRoom(0).getTile(chara);
		ai = new AIPlayer(chara,tileChara);
		System.out.println(ai.getChara().toString());
				
	}
	
	void initHuman() {
		
		// get Hero from dungeon
		Hero myHero = (Hero) dungeon.getRoom(0).getFirstTile().getCharacter().get();
		human = new HumanPlayer(myHero, dungeon.getRoom(0).getFirstTile()); 
		System.out.println(human.getChara().getName());
				
	}

	@Test
	void HumanAttacksAITest() {
		initDungeon();
		initAI();
		initHuman();
		System.out.println(ai.getChara().getHP());
		for (int i = 0; i<=10; i ++) {
			human.attack(ai.getCurrentTile());
			System.out.println(ai.getChara().getHP());
		}	
		assert(ai.isDead());
		System.out.println();
	}
	
	
	
	@Test
	void test() {
		
		System.out.println("Array test");
		var arr = new ArrayList<String>();
		arr.add("hello");
		arr.add("Bonjour");
		arr.add("Hello");
		arr.add("Hallo");
		arr.add("Chaire");
		arr.add("Guten Tag");
		arr.add("Salut!");
		
		arr.stream().filter(s -> s.toLowerCase().charAt(0) == 'h').forEach(System.out::println);
		System.out.println(arr);
		
	}
	@Test
	void AIAttacksHumanTest() {
		initDungeon();
		initAI();
		initHuman();
		
		System.out.println(human.getChara().getHP());
		for (int i = 0; i<=10; i ++) {
			ai.attack(human.getCurrentTile());
			System.out.println(human.getChara().getHP());
		}
		assert(human.isDead());
		System.out.println();

		
	}

}
