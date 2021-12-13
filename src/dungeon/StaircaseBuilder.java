package dungeon;

import java.util.List;

public class StaircaseBuilder {
	
	
	public void createStaircase(List<Staircase> tiles) {	
		for (int i = 0; i<=tiles.size() - 1; i++) {
			 connect(tiles.get(i), tiles.get(i+1));
		 }
	}
	
	public void connect(Staircase lowerPart, Staircase upperPart) {
		lowerPart.setNext(upperPart);
		upperPart.setPrev(lowerPart);
		
	}
	
	
}

