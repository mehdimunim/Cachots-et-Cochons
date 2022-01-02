package dungeon;

import java.util.ArrayList;
import java.util.List;

public class RoomBuilder {
	private Room room;
	
	public RoomBuilder(String name, int level) {
		room = new Room(name, level);
	}
	
	public void addTile(Tile tile) {
		int x = tile.getXPosition();
		if (x <= room.getX()) {
			room.getRow(x).add(tile);
		}
	
		else {
			List<Tile> newRow = new ArrayList<>();
			newRow.add(tile);
			room.getTiles().add(newRow);
		}
		
	}
	
	public Room getRoom() {
		return room;
	}
}
