package main;

import java.util.ArrayList;
import java.util.List;

import dungeon.Room;
import dungeon.Tile;

public abstract class Player<T extends character.Character> {
	/**
	 * Generic player Instance of Character (either Monster or Human)
	 */
	private T chara;
	private dungeon.Tile currentTile;

	public Player(T chara, dungeon.Tile currentTile) {
		this.setChara(chara);
		this.currentTile = currentTile;
	}

	private boolean canReach(dungeon.Tile tile) {
		int distance = this.currentTile.manhattanDistanceTo(tile);

		if (distance == 0) {
			return false;
		}

		else if (distance <= this.getChara().getMove()) {
			return true;
		}
		return false;

	}

	protected boolean canGoTo(dungeon.Tile tile) {

		if (tile.equals(currentTile)) {
			return false;
		} else {
			boolean isOccupied = tile.hasCharacter();
			return canReach(tile) && !isOccupied;
		}
	}

	public void goTo(dungeon.Tile tile) {

		currentTile.removeCharacter();
		tile.addCharacter(getChara());
		currentTile = tile;

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

	//private boolean canAttack(Player<T> player) {
	//	return chara.isEnnemyWith(player.getChara()) && isWithinAttackRange(player.currentTile);
	//}

	public boolean canAttack(dungeon.Tile tile) {
		if (tile.hasCharacter()) {
			character.Character otherChara = tile.getCharacter().get();
			// Check if tile is within attack range (move or per bow) and the characters are
			// ennemy
			return isWithinAttackRange(tile) && chara.isEnnemyWith(otherChara);
		} else {
			// Player cannot attack if the tile is empty
			return false;
		}
	}

	public void attack(Player<T> player) {
		player.getChara().loseHP(getChara().getAttack());

	}

	public void attack(Tile tile) {
		tile.getCharacter().ifPresent(ch -> ch.loseHP(getChara().getAttack()));
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

	public List<Tile> getReachableTiles(Room currentRoom) {
		List<Tile> reachableTiles = new ArrayList<Tile>();
		for (Tile tile : currentRoom) {
			if (canReach(tile)) {
				reachableTiles.add(tile);
			}
		}
		return reachableTiles;

	}

	public boolean isDead() {
		return this.chara.isDead();
	}

}
