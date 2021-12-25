package character;

public class MonsterFactory {

	public Monster createSow() {
		Sow sow = new Sow(10, 10, 20, 20, 1);
		return sow;
	};

	public Monster createBoar() {
		Boar boar = new Boar(10, 10, 10, 10, 2);
		return boar;
	};

	public Monster createShoat() {
		Shoat shoat = new Shoat(3, 1, 1, 1, 5);
		return shoat;
	};

	public static Monster spawnSow(dungeon.Tile tile) {
		Sow sow = new Sow(10, 10, 20, 20, 1);
		tile.addCharacter(sow);
		return sow;
	};

	public static Monster spawnBoar(dungeon.Tile tile) {
		Boar boar = new Boar(10, 10, 10, 10, 2);
		tile.addCharacter(boar);
		return boar;
	};

	public static Monster spawnShoat(dungeon.Tile tile) {
		Shoat shoat = new Shoat(3, 1, 1, 1, 5);
		tile.addCharacter(shoat);
		return shoat;
	};
}
