package dungeon;

import java.util.List;

public class StaircaseBuilder {
	
	
	public void createStaircase(Staircase downTile, Staircase upTile) {		
		downTile.setNext(upTile);
	}
	
	public void createStaircase(List<Tile> tiles) {
		
		for (int i = 0; i<=tiles.size() - 1; i++) {
			 connect(tiles.get(i), tiles.get(i+1));
		 }
	}
	
	public void connect(Staircase lowerPart, Staircase upperPart) {
		
		lowerPart.setNext(lowerPart);
	}
	
	public void connect(Tile lowerPart, Tile upperPart) {
		
		upperPart = new Staircase(upperPart, null);
		lowerPart = new Staircase(lowerPart, (Staircase) upperPart );
	}
	
	
}

