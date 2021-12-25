package dungeon;

import java.util.List;

import character.Character;
import character.Hero;

public interface DungeonBuilder {

	public Dungeon getDungeon();

	public void createRoom(int roomDim, int level);

	public void setDifficulty(int difficulty);

	public void addRoom(Room room);

	public void addRooms(List<Room> rooms);

	public void addHero(Hero hero);

	public void build();

	public void setDifficulty();
}
