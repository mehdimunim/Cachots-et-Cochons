package main;

import java.util.ArrayList;
import java.util.List;

import dungeon.Room;
import dungeon.Tile;
import inventory.Staircase;

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

	public void attack(Tile tile) {
		if (tile.getCharacter().isPresent()) {
			character.Character ennemy = tile.getCharacter().get();
			ennemy.loseHP(chara.getAttack());
		}
	}

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

	protected boolean canGoTo(dungeon.Tile tile) {

		if (tile.equals(currentTile)) {
			return false;
		} else {
			boolean isOccupied = tile.hasCharacter();
			return canReach(tile) && !isOccupied;
		}
	}

	private boolean canReach(dungeon.Tile tile) {
		int distance = this.currentTile.manhattanDistanceTo(tile);

		if (distance == 0) {
		}

		else if (distance <= this.getChara().getMove()) {
			return true;
		}
		return false;

	}

	protected abstract boolean choosesToGoStaircase();

	// private boolean canAttack(Player<T> player) {
	// return chara.isEnnemyWith(player.getChara()) &&
	// isWithinAttackRange(player.currentTile);
	// }

	public T getChara() {
		return chara;
	}

	public dungeon.Tile getCurrentTile() {
		return currentTile;
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

	public void goStaircase(Room adjRoom) {
		goTo(adjRoom.getTile(currentTile.getXPosition(), currentTile.getYPosition() + 1));

	}

	public void goTo(dungeon.Tile tile) {

		currentTile.removeCharacter();
		tile.addCharacter(getChara());
		currentTile = tile;

	}

	public boolean isDead() {
		return this.chara.isDead();
	}

	public boolean isOnStaircase() {
		if (currentTile.hasItem()) {
			return currentTile.getItem().get() instanceof Staircase;
		}
		return false;
	}

	public boolean isOnUp() {
		if (isOnStaircase()) {
			Staircase staircase = (Staircase) (currentTile.getItem().get());
			return staircase.isUp();
		}
		return false;
	}

	public boolean isWithinAttackRange(dungeon.Tile tile) {
		return canReach(tile) || isWithinBowRange(tile);
	}

	public boolean isWithinBowRange(dungeon.Tile tile) {

		double distance = this.currentTile.euclidianDistanceTo(tile);

		if (distance < this.getChara().getBowRange()) {
			return true;
		}
		return false;

	}

	public void play(List<Tile> reachableTiles) {
		// TODO Auto-generated method stub

	}

	public void setChara(T chara) {
		this.chara = chara;
	}

	public void setCurrentTile(dungeon.Tile currentTile) {
		this.currentTile = currentTile;
	}

}
