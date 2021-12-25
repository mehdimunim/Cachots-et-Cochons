package dungeon;

import java.text.ParseException;
import java.util.List;

import org.w3c.dom.Element;

import character.Hero;
import inventory.Item;

import character.Character;

public interface DungeonParser {
	
	public int parseDifficulty(Element mainElement)throws ParseException; 
	
	public Dungeon parseDungeon(Element mainElement)throws ParseException;
	
	public List<Room> parseRooms(Element mainElement)throws ParseException;

	public Staircase parseStaircase(Element mainElement)throws ParseException;
	
	public Room parseRoom(Element element)throws ParseException;
	
	public Item parseItem(Element element) throws ParseException;
	
	public Character parseCharacter(Element element)throws ParseException;
	
	public Tile parseTile(Element element)throws ParseException;
	
	

	
	

}
