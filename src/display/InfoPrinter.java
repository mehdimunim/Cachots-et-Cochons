package display;

import dungeon.Room;
import main.HumanPlayer;

public class InfoPrinter {

	
	public static void display(character.Hero hero, dungeon.Room room) {
		
		StringBuilder sb = new StringBuilder("INFO CHARACTER\n");
		
		sb.append("Name: " + hero.getName() + "\n");
		sb.append("Attack: " + hero.getAttack() + "\n");
		sb.append("Defense: " + hero.getDefense() + "\n");
		sb.append("HP: " + hero.getHP() + "\n") ;
		sb.append("XP: " + hero.getXP() + "\n");
		sb.append("Move: " + hero.getMove() + "\n");
		sb.append("\n");
		System.out.print(sb.toString());
		
		sb = new StringBuilder("INFO ROOM\n");
		
		sb.append("Description: " + room.getDescription() + "\n");
		
		System.out.print(sb.toString());
	}

	public static void update(Room currentRoom, HumanPlayer humanPlayer) {
		display(humanPlayer.getChara(), currentRoom);
		
	}
}
