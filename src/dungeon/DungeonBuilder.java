package dungeon;

import java.util.List;

import character.Hero;

public interface DungeonBuilder {

	public void addHero(Hero hero);

	public void addRoom(Room room);

	public void addRooms(List<Room> rooms);

	public void build();

	public void createRoom(int roomDim, int level);

	public Dungeon getDungeon();

	public void setDifficulty();

	public void setDifficulty(int difficulty);
}
