package dungeon;

import java.io.IOException; // builder.parse()
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// factory.newDocumentBuilder() can throw a ParserConfigurationException
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException; // builder.parse()

import character.Character;
import character.Hero;
import character.MonsterFactory;
import inventory.DefaultItemFactory;
import inventory.Item;

public class BasicDungeonParserFromXML implements DungeonParser {

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

	@Override
	public Dungeon parseDungeon(Element mainElement) throws ParseException {
		int difficulty = parseDifficulty(mainElement);
		List<Room> rooms = parseRooms(mainElement);

		return buildDungeon(difficulty, rooms);

	}

	private Dungeon buildDungeon(int diff, List<Room> rooms) {
		Dungeon dungeon = new BasicDungeon();
		dungeon.setDifficulty(diff);
		rooms.forEach(r -> dungeon.addRoom(r));
		return dungeon;
	}

	@Override
	public List<Room> parseRooms(Element mainElement) throws ParseException {
		var listRooms = new ArrayList<Room>();
		var nodeList = mainElement.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				listRooms.add(parseRoom(elem));
			}
		}
		return listRooms;
	}
	
	@Override
	public Tile parseTile(Element element) throws ParseException {

		// get all attributes
		int xPosition = Integer.parseInt(element.getElementsByTagName("xPosition").item(0).getTextContent());
		int yPosition = Integer.parseInt(element.getElementsByTagName("yPosition").item(0).getTextContent());
		Character chara = parseCharacter(element);
		Item item = parseItem(element);

		// build tile
		Tile tile = new Tile(xPosition, yPosition);
		tile.addCharacter(chara);
		tile.addItem(item);

		return tile;
	}

	@Override
	public Room parseRoom(Element element) throws ParseException {

		String name = element.getElementsByTagName("name").item(0).getTextContent();
		int level = Integer.parseInt(element.getElementsByTagName("level").item(0).getTextContent());
		var nodeList = element.getElementsByTagName("tiles").item(0).getChildNodes();

		var listTiles = new ArrayList<Tile>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				listTiles.add(parseTile(elem));
			}
		}

		return buildRoom(name, level, listTiles);
	}

	private Room buildRoom(String name, int level, List<Tile> listTiles) {

		int xDim = getMaxXPosition(listTiles);
		int yDim = getMaxYPosition(listTiles);

		Room room = new Room(xDim, yDim, name, level);

		return getfilledRoom(room, listTiles);
	}

	private Room getfilledRoom(Room room, List<Tile> listTiles) {
		/**
		 * Fill an empty room with the correct tiles
		 */

		listTiles.forEach(t -> t.getCharacter()
				.ifPresent(chara -> room.getTile(t.getXPosition(), t.getYPosition()).addCharacter(chara)));
		listTiles.forEach(
				t -> t.getItem().ifPresent(item -> room.getTile(t.getXPosition(), t.getYPosition()).addItem(item)));
		return room;
	}

	private int getMaxXPosition(List<Tile> listTiles) {
		if (listTiles.isEmpty()) {
			return 0;
		}
		return listTiles.stream().mapToInt(Tile::getXPosition).max().getAsInt();
	}

	private int getMaxYPosition(List<Tile> listTiles) {
		if (listTiles.isEmpty()) {
			return 0;
		}
		return listTiles.stream().mapToInt(Tile::getYPosition).max().getAsInt();
	}

	@Override
	public Item parseItem(Element element) throws ParseException {
		String item = element.getElementsByTagName("item").item(0).getTextContent();
		var fac = new DefaultItemFactory();
		switch (item) {

		case "Bow":
			return fac.createBow();
		case "Sword":
			return fac.createSword();
		case "Shield":
			return fac.createShield();
		case "Potion":
			return fac.createPotion();
		default:
			throw new ParseException(item, 0);

		}

	}

	@Override
	public Character parseCharacter(Element element) throws ParseException {
		String character = element.getElementsByTagName("item").item(0).getTextContent();

		var fac = new MonsterFactory();
		switch (character) {

		case "Hero":
			return Hero.createDefaultHero();

		case "Boar":
			return fac.createBoar();

		case "Sow":
			return fac.createSow();

		case "Shoat":
			return fac.createShoat();

		default:
			throw new ParseException(character, 0);
		}

	}

	@Override
	public int parseDifficulty(Element mainElement) {
		return Integer.parseInt(mainElement.getElementsByTagName("difficulty").item(0).getTextContent());
	};

}
