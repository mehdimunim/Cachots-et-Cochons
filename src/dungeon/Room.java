package dungeon;
import java.util.ArrayList;
import java.util.List;

public class Room {
	
	List<Tile> tiles = new ArrayList<Tile>();
	private String description = "No description";
	int x;
	int y;
	
	public Room(int x, int y, String desc) {
		this.description = desc;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getDescription() {
		return this.description;
	};
	
	public List<Tile> getTiles() {
		return this.getTiles();
	}
}
