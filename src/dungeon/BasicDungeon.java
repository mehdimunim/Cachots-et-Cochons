package dungeon;

public class BasicDungeon extends Dungeon {

	@Override
	public BasicDungeon clone() throws CloneNotSupportedException {
		BasicDungeon bd = new BasicDungeon();

		bd.setDifficulty(getDifficulty());
		// clone each room and add to the new dungeon in the correct order
		getRooms().stream().forEachOrdered(room -> bd.addRoom(room.clone()));

		return bd;
	}

}
