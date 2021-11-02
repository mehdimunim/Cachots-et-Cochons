package inventory;

import java.util.List;
public class Bow extends Item{
	
	int range;
	List<Arrow> quiver;
	
	public Bow(int range, List<Arrow> quiver) {
		this.range = range;
		this.quiver = quiver;
		
	}
	public void shoot(Arrow arrow) {
		quiver.remove(arrow);
	}
	
	public void loadArrow(Arrow arrow) {
		quiver.add(arrow);
	}

}
