package character;

public class MonsterFactory {

	public static Sow createSow() {
		return new Sow(10, 10, 20, 20, 1);
	};

	public static Boar createBoar() {
		return new Boar(10, 10, 10, 10, 2);
	};

	public static Shoat createShoat() {
		return new Shoat(3, 1, 1, 1, 5);
	};
}
