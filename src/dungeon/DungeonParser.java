package dungeon;

import java.text.ParseException;

/**
 * Interface to read a dungeon from a file
 *
 * @author Mehdi
 *
 */
public interface DungeonParser {

	Dungeon getDungeon(String file) throws ParseException;

}
