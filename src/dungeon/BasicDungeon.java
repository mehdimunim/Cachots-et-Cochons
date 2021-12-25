package dungeon;

public class BasicDungeon extends Dungeon {
	
	@Override
	public Dungeon clone() throws CloneNotSupportedException {
		return (BasicDungeon) super.clone();
	}	

}
