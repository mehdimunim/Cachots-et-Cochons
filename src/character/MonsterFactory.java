package character;

public class MonsterFactory {

	public static Sow createOrc() {
		return new Sow(0, 0, 0,0,0);
	};
	
	public static Boar createDragon() {
		return new Boar(0, 0, 0,0,0);
	};
	
	public static Pig createKobold() {
		return new Pig(0, 0, 0,0,0);
	};
}
