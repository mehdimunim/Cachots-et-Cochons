package character;

public class MonsterFactory {

	public static Orc createOrc() {
		return new Orc(0, 0, 0,0,0);
	};
	
	public static Dragon createDragon() {
		return new Dragon(0, 0, 0,0,0);
	};
	
	public static Kobold createKobold() {
		return new Kobold(0, 0, 0,0,0);
	};
}
