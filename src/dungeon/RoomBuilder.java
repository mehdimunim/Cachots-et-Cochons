package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	public Room getRoom() throws InvalidRoomException {
		List<Integer> rowSizes = room.getTiles().stream().map(row -> row.size()).collect(Collectors.toList());
		if (Collections.max(rowSizes) != Collections.min(rowSizes)) {
			throw new InvalidRoomException("The room is not a rectangle");
		}
		return room;
	}
}
