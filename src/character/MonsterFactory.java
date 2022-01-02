package character;
import dungeon.Tile;

public class MonsterFactory {

	public Monster createSow() {
		Sow sow = new Sow(0, 400, 20, 20, 1);
		return sow;
	};

	public Monster createBoar() {
		Boar boar = new Boar(10, 200, 50, 10, 1);
		return boar;
	};

	public Monster createShoat() {
		Shoat shoat = new Shoat(3, 100, 10, 1, 2);
		return shoat;
	};

	public Monster spawnSow(Tile tile) {
		Monster sow = createSow();
		tile.addCharacter(sow);
		return sow;
	};

	public Monster spawnBoar(Tile tile) {
		Monster boar = createBoar();
		tile.addCharacter(boar);
		return boar;
	};

	public Monster spawnShoat(Tile tile) {
		Monster shoat = createShoat();
		tile.addCharacter(shoat);
		return shoat;
	};
}
