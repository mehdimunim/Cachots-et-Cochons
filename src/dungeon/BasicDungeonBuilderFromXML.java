package dungeon;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// factory.newDocumentBuilder() can throw a ParserConfigurationException
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; // builder.parse()
import java.io.IOException; // builder.parse()
import java.text.ParseException;

import character.Character;
import character.Hero;
import character.MonsterFactory;
import inventory.Arrow;
import inventory.Bow;
import inventory.Item;
import inventory.Potion;
import inventory.DefaultItemFactory;

public class BasicDungeonBuilderFromXML implements DungeonParser, DungeonBuilder {

	public Element getMainElement(String xmlFile) {
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
	public Dungeon parseDungeon(Element mainElement) {
		return null;
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
	public Staircase parseStaircase(Element mainElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room parseRoom(Element element) throws ParseException {
		
		String name = element.getElementsByTagName("name").item(0).getTextContent();
		int level = Integer.parseInt(element.getElementsByTagName("level").item(0).getTextContent());
		var nodeList = element.getElementsByTagName("tiles").item(0).getChildNodes();
		
		var listTiles = new ArrayList<Tile>();
		for (int i = 0; i< nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				listTiles.add(parseTile(elem));
			}
		}
		
		return null;
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

	@Override
	public void createRoom(int roomDim, int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void build() {
		// TODO Auto-generated method stub

	}

	@Override
	public Dungeon getDungeon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDifficulty(int difficulty) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRooms(List<Room> rooms) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHero(Hero hero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDifficulty() {
		// TODO Auto-generated method stub

	}

	@Override
	public Tile parseTile(Element element) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
