package inventory;

public class Staircase extends Item {
	private boolean up;

	public Staircase(String direction) {
		if (direction.toLowerCase().equals("up")) {
			up = true;
		}
		else if (direction.toLowerCase().equals("down")) {
			up = false;
		}
		else {
			throw new IllegalArgumentException("Wrong direction argument for the staircase");
		}
		
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
	
	@Override
	public String getFullDescription() {
		String dir = up? "Up": "Down";
		return "Staircase, direction: " + dir;
	}
	

}
