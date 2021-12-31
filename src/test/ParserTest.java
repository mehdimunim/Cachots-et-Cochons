package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import dungeon.DungeonXMLParser;
class ParserTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void DungeonParsingTest() {
		String xml = "C:\\Users\\Mehdi\\GitHub\\Cachots et Cochons\\src\\example\\BasicDungeonExample.xml";
		var bdpxml = new DungeonXMLParser(); 
		try {
			bdpxml.getDungeon(xml);
			assert(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error while Parsing");
		}
	}

}
