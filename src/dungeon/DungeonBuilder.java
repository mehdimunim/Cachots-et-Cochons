package dungeon;

import java.util.List;

import character.Hero;

/**
 * Build a dungeon and implements the Builder design Pattern
 *
 * @author Mehdi
 *
 */
public interface DungeonBuilder {

	public void addHero(Hero hero) throws NonEmptyTileException;

	public void addRoom(Room room);

	public void addRooms(List<Room> rooms);

	public void build();

	public void createRoom(int roomDim, int level) throws NonEmptyTileException;

	public Dungeon getDungeon();

	public void setDifficulty();

	public void setDifficulty(int difficulty);
}
