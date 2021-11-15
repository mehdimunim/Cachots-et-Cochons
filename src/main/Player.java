package main;

import java.util.List;

import dungeon.Tile;

public abstract class Player<T extends character.Character>{
	/**
	 * Generic player
	 * Instance of Character (either Monster or Human)
	 */
	private T chara;
	private dungeon.Tile currentTile;

	public Player(T chara, dungeon.Tile currentTile) {
		this.setChara(chara);
		this.currentTile = currentTile;
	}

	private boolean canReach(dungeon.Tile tile) {
		int distance = this.currentTile.manhattanDistanceTo(tile);

		if (distance < this.getChara().getMove()) {
			return true;
		}
		return false;

	}
	
	private boolean canGoTo(dungeon.Tile tile) {
		
		boolean isOccupied = tile.hasCharacter();
		return canReach(tile) && isOccupied;
}

	
	public void move(dungeon.Tile tile) {

		if (canGoTo(tile)) {
			currentTile.removeCharacter();
			tile.addCharacter(getChara());
		}

	}
	
	public boolean isWithinBowRange(dungeon.Tile tile) {
		
		double distance = this.currentTile.euclidianDistanceTo(tile);

		if (distance < this.getChara().getBowRange()) {
			return true;
		}
		return false;
		
	}
	public boolean isWithinAttackRange(dungeon.Tile tile) {
		return canReach(tile) || isWithinBowRange(tile);
	}
	
	public boolean canAttack(Player<T> player) {
		return chara.isEnnemyWith(player.getChara()) && isWithinAttackRange(player.currentTile);
	}

	public void attack(Player<T> player) {
		player.getChara().loseHP(getChara().getAttack());

	}
	
	public void play() {
		
	}

	public T getChara() {
		return chara;
	}

	public void setChara(T chara) {
		this.chara = chara;
	}

	public void play(List<Tile> reachableTiles) {
		// TODO Auto-generated method stub
		
	}

	public dungeon.Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(dungeon.Tile currentTile) {
		this.currentTile = currentTile;
	}

}
