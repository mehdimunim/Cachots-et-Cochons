package main;

public class Player {
	private character.Character chara;
	private dungeon.Tile currentTile;
	
	public void move(dungeon.Tile tile) {
		
		currentTile.removeCharacter();
		tile.addCharacter(chara);
		
	}
	
	

}
