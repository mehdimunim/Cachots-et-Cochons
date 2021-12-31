package dungeon;

import java.text.ParseException;

public interface DungeonParser {

	Dungeon getDungeon(String file) throws ParseException;

}
