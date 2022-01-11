package character;

import dungeon.NonEmptyTileException;
import dungeon.Tile;

/**
 * Create monsters with average attributes.
 *
 * @author Mehdi
 *
 */
public class DefaultMonsterFactory implements MonsterFactoryInterface {

	@Override
	public Monster createBoar() {
		Boar boar = new Boar(10, 200, 50, 10, 1);
		return boar;
	}

	@Override
	public Monster createShoat() {
		Shoat shoat = new Shoat(3, 100, 10, 1, 2);
		return shoat;
	}

	@Override
	public Monster createSow() {
		Sow sow = new Sow(0, 400, 20, 20, 1);
		return sow;
	}

	/**
	 * The spawn methods create a monster on a tile
	 *
	 * @param tile: tile where to create the monster
	 */
	public Monster spawnBoar(Tile tile) {
		Monster boar = createBoar();
		try {
			tile.addCharacter(boar);
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}
		return boar;
	}

	public Monster spawnShoat(Tile tile) {
		Monster shoat = createShoat();
		try {
			tile.addCharacter(shoat);
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}
		return shoat;
	}

	public Monster spawnSow(Tile tile) {
		Monster sow = createSow();
		try {
			tile.addCharacter(sow);
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}
		return sow;
	}
}
