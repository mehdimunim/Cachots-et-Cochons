package dungeon;

import java.util.List;

import character.DefaultMonsterFactory;
import character.Hero;
import inventory.DefaultItemFactory;

/**
 * Builds a basic dungeon
 *
 * @author Mehdi
 *
 */
public class BasicDungeonBuilder implements DungeonBuilder {
	private BasicDungeon dungeon = new BasicDungeon();

	/**
	 * Add a Hero and add it in the first room
	 *
	 * @throws NonEmptyTileException
	 */
	@Override
	public void addHero(Hero hero) throws NonEmptyTileException {
		dungeon.getRoom(0).addHero(hero);
	}

	@Override
	public void addRoom(Room room) {
		dungeon.addRoom(room);
	}

	@Override
	public void addRooms(List<Room> rooms) {
		dungeon.getRooms().addAll(rooms);
	}

	/**
	 * Add a staircase between two rooms at given XY position
	 *
	 * @param downRoom: room to build the lower part of the staircase
	 * @param upRoom:   room to build the upper part of the staircase
	 * @param i:        X-coordinate of the tile with staircase in the two rooms.
	 * @param j:        Y-coordinate of the tile with staircase in the two rooms.
	 * @throws NonEmptyTileException
	 */
	public void addStaircase(Room downRoom, Room upRoom, int i, int j) throws NonEmptyTileException {
		DefaultItemFactory fac = new DefaultItemFactory();
		downRoom.getTile(i, j).addItem(fac.createDownStaircase());
		upRoom.getTile(i, j).addItem(fac.createUpStaircase());
	}

	/**
	 * Build the basic dungeon with three rooms and one staircase between Room 0 and
	 * 1.
	 */
	@Override
	public void build() {
		this.setDifficulty();
		for (int i = 0; i < 3; i++) {
			try {
				createRoom(10, i);
			} catch (NonEmptyTileException e) {
				e.printStackTrace();
			}
		}
		try {
			addStaircase(dungeon.getRoom(0), dungeon.getRoom(1), 3, 4);
		} catch (NonEmptyTileException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a n*n room in the builder
	 *
	 * @param roomDim: with of the room = length
	 * @param level:   Z-coordinate of the room in the dungeon
	 * @throws NonEmptyTileException
	 */
	@Override
	public void createRoom(int roomDim, int level) throws NonEmptyTileException {

		Room room = new Room(roomDim, roomDim, "Room " + level, level);
		DefaultMonsterFactory mFac = new DefaultMonsterFactory();
		// fill the room
		// fill with monsters
		// +1 because hero is already at tile 0
		// mod the size of the room
		mFac.spawnBoar(room.getTile(1 + level % roomDim * roomDim));
		mFac.spawnSow(room.getTile(2 + level % roomDim * roomDim));
		mFac.spawnShoat(room.getTile(3 + level % roomDim * roomDim));

		// fill with items
		DefaultItemFactory dFac = new DefaultItemFactory();
		room.getTile(1 + level % roomDim * roomDim).addItem(dFac.createPotion());
		room.getTile(5 + level % roomDim * roomDim).addItem(dFac.createPotion());
		room.getTile(6 + level % roomDim * roomDim).addItem(dFac.createPotion());
		room.getTile(10 + level % roomDim * roomDim).addItem(dFac.createSword());

		addRoom(room);
	}

	/**
	 * Get the dungeon. Needs building first.
	 *
	 */
	@Override
	public Dungeon getDungeon() {
		return dungeon;
	}

	@Override
	public void setDifficulty() {
		this.setDifficulty(0);
	}

	@Override
	public void setDifficulty(int difficulty) {
		dungeon.setDifficulty(difficulty);
	}

}
