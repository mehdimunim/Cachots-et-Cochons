package character;

public class MonsterFactory {

	public static Sow spawnSow(dungeon.Tile tile) {
		Sow sow = new Sow(10, 10, 20, 20, 1);
		tile.addCharacter(sow);
		return sow;
	};

	public static Boar spawnBoar(dungeon.Tile tile) {
		Boar boar = new Boar(10, 10, 10, 10, 2);
		tile.addCharacter(boar);
		return boar;
	};

	public static Shoat spawnShoat(dungeon.Tile tile) {
		Shoat shoat = new Shoat(3, 1, 1, 1, 5);
		tile.addCharacter(shoat);
		return shoat;
	};
}
