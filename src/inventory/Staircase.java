package inventory;

/**
 * A staircase element object to move from one tile to another.
 *
 * @author Mehdi
 *
 */
public class Staircase extends Item {
	/**
	 * Position of the staircase (a down staircase element is under an up staircase
	 * element).
	 */
	private boolean up;

	public Staircase(String direction) {
		if (direction.toLowerCase().equals("up")) {
			up = true;
		} else if (direction.toLowerCase().equals("down")) {
			up = false;
		} else {
			throw new IllegalArgumentException("Wrong direction argument for the staircase");
		}

	}

	@Override
	public Staircase clone() {
		return new Staircase(up ? "up" : "down");
	}

	@Override
	public String getFullDescription() {
		String dir = up ? "Up" : "Down";
		return "Staircase, direction: " + dir;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	@Override
	public String toString() {
		return "X";
	}

}
