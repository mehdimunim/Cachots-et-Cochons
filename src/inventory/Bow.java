package inventory;

import java.util.ArrayList;
public class Bow extends Item{
	
	int range;
	ArrayList<Arrow> quiver = new ArrayList<>();
	
	public void shoot(Arrow arrow) {
		quiver.remove(arrow);
	}
	
	public void loadArrow(Arrow arrow) {
		quiver.add(arrow);
	}

}
