package dungeon;

import java.util.List;

public class StaircaseBuilder {
	
	
	public void createStaircase(List<Tile> tiles) {	
		for (int i = 0; i<=tiles.size() - 1; i++) {
			Staircase downTile = new Staircase(tiles.get(i));
			Staircase upTile = new Staircase(tiles.get(i +1 ));
			connect(downTile, upTile);
		 }
	}
	
	public void createStaircase(Tile downTile, Tile upTile) {	
		createStaircase(List.of(downTile, upTile));
	}
	private void connect(Staircase lowerPart, Staircase upperPart) {
		lowerPart.setNext(upperPart);
		upperPart.setPrev(lowerPart);
		
	}
	
	
}

