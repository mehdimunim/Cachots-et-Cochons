package main;

import dungeon.Tile;

public class HumanPlayer extends Player<character.Hero> {

	public HumanPlayer(character.Hero hero, Tile currentTile) {
		super(hero, currentTile);
		// TODO Auto-generated constructor stub
	}
	
	public void grabItem(dungeon.Tile tile) {
		
		this.chara.addItem(tile.getItem());
		
		}
	
	@Override
	public void play() {
		
	};

}
