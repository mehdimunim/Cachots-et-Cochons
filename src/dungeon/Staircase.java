package dungeon;

public class Staircase extends Tile {
	private Staircase nextTile; // next staircase tile
	private Staircase prevTile; // previous staircase tile

	public Staircase(int XPosition, int YPosition, Staircase prevTile, Staircase nextTile) {
		super(XPosition, YPosition);
		this.prevTile = prevTile;
		this.nextTile = nextTile;
	}

	public Staircase(Tile tile, Staircase prevTile, Staircase nextTile) {
		this(tile.getXPosition(), tile.getYPosition(), prevTile, nextTile);
	}

	public boolean isFirst() {
		return prevTile == null;
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

	public Staircase getPrev() {
		return prevTile;
	}

	public void setPrev(Staircase prevTile) {
		this.prevTile = prevTile;
	}

	@Override
	public boolean isStaircase() {
		return true;
	}
}
