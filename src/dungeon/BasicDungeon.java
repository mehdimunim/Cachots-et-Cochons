package dungeon;

public class BasicDungeon extends Dungeon {

	private BasicDungeon() {
		this.difficulty = 0;

		int roomDim = 20;

		Room room1 = new Room(roomDim, roomDim, "First Room", 1);
		Room room2 = new Room(roomDim, roomDim, "Second Room", 2);
		Room room3 = new Room(roomDim, roomDim, "Third Room", 3);

		this.rooms.add(room1);
		this.rooms.add(room2);
		this.rooms.add(room3);

	}

	@Override
	public Dungeon clone() {
		return new BasicDungeon();
	}
}
