package dungeon;

import java.io.IOException; // builder.parse()
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// factory.newDocumentBuilder() can throw a ParserConfigurationException
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; // builder.parse()

import character.Character;
import character.DefaultMonsterFactory;
import character.Hero;
import inventory.DefaultItemFactory;
import inventory.Item;
import inventory.Staircase;

/**
 * Parse a basic dungeon from an XML file. Uses javax.xml.parsers and
 * org.w3c.dom.
 *
 * @author Mehdi
 *
 */
public class BasicDungeonXMLParser implements DungeonParser {

	/**
	 * Build a dungeon from the list of its elements.
	 *
	 * @param diff:  difficulty of the dungeon
	 * @param rooms: list of rooms
	 * @return the dungeon object from the input elements
	 */
	private Dungeon buildDungeon(int diff, List<Room> rooms) {
		Dungeon dungeon = new BasicDungeon();
		dungeon.setDifficulty(diff);
		rooms.forEach(r -> dungeon.addRoom(r));
		return dungeon;
	}

	@Override
	public Dungeon getDungeon(String xmlFile) throws ParseException {

		Element mainElement = getMainElement(xmlFile);
		return parseDungeon(mainElement);
	}

	private Element getMainElement(String xmlFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xmlFile);
			return document.getDocumentElement();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.err.println("Error parsing XML: " + e.getMessage());
		}
		return null;
	}

	public Optional<Character> parseCharacter(Element element) throws ParseException {
		String character = element.getElementsByTagName("character").item(0).getTextContent();
		DefaultMonsterFactory fac = new DefaultMonsterFactory();
		switch (character) {

		case "Hero":
			return Optional.of(Hero.createDefaultHero());

		case "Boar":
			return Optional.of(fac.createBoar());

		case "Sow":
			return Optional.of(fac.createSow());

		case "Shoat":
			return Optional.of(fac.createShoat());

		default:
			return Optional.empty();
		}
	}

	public int parseDifficulty(Element mainElement) {
		return Integer.parseInt(mainElement.getElementsByTagName("difficulty").item(0).getTextContent());
	}

	public Dungeon parseDungeon(Element mainElement) throws ParseException {
		int difficulty = parseDifficulty(mainElement);
		List<Room> rooms = parseRooms(mainElement);

		return buildDungeon(difficulty, rooms);

	}

	public Optional<Item> parseItem(Element element) throws ParseException {
		String item = element.getElementsByTagName("item").item(0).getTextContent();
		DefaultItemFactory fac = new DefaultItemFactory();
		switch (item) {

		case "Bow":
			return Optional.of(fac.createBow());
		case "Sword":
			return Optional.of(fac.createSword());
		case "Shield":
			return Optional.of(fac.createShield());
		case "Potion":
			return Optional.of(fac.createPotion());
		case "Staircase down":
			return Optional.of(new Staircase("down"));
		case "Staircase up":
			return Optional.of(new Staircase("up"));
		default:
			return Optional.empty();

		}

	}

	public Room parseRoom(Element element) throws ParseException {

		String name = element.getElementsByTagName("name").item(0).getTextContent();
		int level = Integer.parseInt(element.getElementsByTagName("level").item(0).getTextContent());
		NodeList nodeList = element.getElementsByTagName("tiles").item(0).getChildNodes();

		RoomBuilder rb = new RoomBuilder(name, level);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				rb.addTile(parseTile(elem));
			}
		}

		return rb.getRoom();
	}

	public List<Room> parseRooms(Element mainElement) throws ParseException {
		List<Room> listRooms = new ArrayList<Room>();
		NodeList nodeList = mainElement.getElementsByTagName("rooms").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				listRooms.add(parseRoom(elem));
			}
		}
		return listRooms;
	}

	public Tile parseTile(Element element) throws ParseException {

		// get tile position
		int xPosition = Integer.parseInt(element.getElementsByTagName("xPosition").item(0).getTextContent());
		int yPosition = Integer.parseInt(element.getElementsByTagName("yPosition").item(0).getTextContent());
		// build tile
		Tile tile = new Tile(xPosition, yPosition);

		// complete tile with character and item
		parseCharacter(element).ifPresent(chara -> {
			try {
				tile.addCharacter(chara);
			} catch (NonEmptyTileException e) {
				e.printStackTrace();
			}
		});
		parseItem(element).ifPresent(it -> {
			try {
				tile.addItem(it);
			} catch (NonEmptyTileException e) {
				e.printStackTrace();
			}
		});

		return tile;
	}

}
