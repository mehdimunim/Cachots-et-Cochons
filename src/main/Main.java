package main;

import dungeon.*;
import display.*;
import character.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("The game starts");

		Room room = new Room(10, 10, "", 0);

		Hero hero = Hero.getDefaultHero();

		RoomPrinter.display(room, hero);
		
		RoomManager rm = new RoomManager();
		
		for (character.Character chara : room.getCharacters()) {
			rm.play(chara);
		}
		
		rm.play(hero);

	}

}
