package main;

public abstract class Player {
	character.Character chara;
	dungeon.Tile currentTile;

	public Player(character.Character chara, dungeon.Tile currentTile) {
		this.chara = chara;
		this.currentTile = currentTile;
	}

	private boolean canReach(dungeon.Tile tile) {
		int distance = this.currentTile.manhattanDistanceTo(tile);

		if (distance < this.chara.getMove()) {
			return true;
		}
		return false;

	}
	
	private boolean canGoTo(dungeon.Tile tile) {
		
		boolean isOccupied = tile.hasCharacter();
		return canReach(tile) && isOccupied;
}

	public boolean isEnnemyWith(Player player) {
		return false;
	}
	
	public void move(dungeon.Tile tile) {

		if (canGoTo(tile)) {
			currentTile.removeCharacter();
			tile.addCharacter(chara);
		}

	}
	
	public boolean isWithinBowRange(dungeon.Tile tile) {
		
		double distance = this.currentTile.euclidianDistanceTo(tile);

		if (distance < this.chara.getBowRange()) {
			return true;
		}
		return false;
		
	}
	public boolean isWithinAttackRange(dungeon.Tile tile) {
		return canReach(tile) || isWithinBowRange(tile);
	}
	
	public boolean canAttack(Player player) {
		return isEnnemyWith(player) && isWithinAttackRange(player.currentTile);
	}

	public void attack(Player player) {
		player.chara.loseHP(chara.getAttack());

	}
	
	public void play() {
		
	}

}
