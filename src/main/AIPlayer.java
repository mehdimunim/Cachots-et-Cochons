package main;

import character.Character;
import dungeon.Tile;

import java.util.
public class AIPlayer extends Player<character.Character> {

	public AIPlayer(Character chara, Tile currentTile) {
		super(chara, currentTile);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void play() {
		
		double randInt = Math.floor(10*Math.random());
		
		
}
}
