package inventory;

import java.util.List;
public class Bow extends Item{
	
	private int range;
	private List<Arrow> quiver;
	
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
	
	public int getRange() {
		return this.range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	@Override
	public String toString() {
		return ")";
	}

}
