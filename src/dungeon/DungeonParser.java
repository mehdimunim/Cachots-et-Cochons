package dungeon;

import java.text.ParseException;
import java.util.List;

import org.w3c.dom.Element;

import character.Character;
import inventory.Item;

public interface DungeonParser {
	
	int parseDifficulty(Element mainElement)throws ParseException; 
	
	Dungeon parseDungeon(Element mainElement)throws ParseException;
	
	List<Room> parseRooms(Element mainElement)throws ParseException;

	List<Staircase>  parseStaircases(Element mainElement)throws ParseException;
	
	Room parseRoom(Element element)throws ParseException;
	
	Item parseItem(Element element) throws ParseException;
	
	Character parseCharacter(Element element)throws ParseException;
	
	Tile parseTile(Element element)throws ParseException;

	Dungeon getDungeon(String xmlFile) throws ParseException;
	

	
	

	
	

}
