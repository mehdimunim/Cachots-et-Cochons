package dungeon;

public class Staircase extends Tile {
	private Staircase nextTile; //next staircase tile
	
	public Staircase(int XPosition, int YPosition, Staircase nextTile) {
		super(XPosition, YPosition);
		this.nextTile = nextTile;
	}
	
	public Staircase(Tile tile, Staircase nextTile) {
		this(tile.getXPosition(), tile.getYPosition(), nextTile);
	}

	public boolean isLast() {
		return nextTile == null;
	}

	public Staircase getNext() {
		return this.nextTile;
	}
	public void setNext(Staircase nextTile) {
		this.nextTile = nextTile;
		
	}
	
	@Override
	public String getDepiction() {
		return "X";
	}
	
	
}
