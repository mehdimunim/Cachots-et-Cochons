package inventory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A bow that can shoot arrows
 *
 * @author Mehdi
 *
 */
public class Bow extends Item {

	private int range;
	private List<Arrow> quiver;

	public Bow(int range, List<Arrow> quiver) {
		this.range = range;
		this.quiver = quiver;

	}

	@Override
	public Bow clone() {
		List<Arrow> clonedQuiver = quiver.stream().map(a -> a.clone()).collect(Collectors.toList());
		return new Bow(range, clonedQuiver);
	}

	@Override
	public String getFullDescription() {
		return "Bow, range: " + String.valueOf(range);
	}

	public int getRange() {
		return range;
	}

	public void loadArrow(Arrow arrow) {
		quiver.add(arrow);
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void shoot(Arrow arrow) {
		quiver.remove(arrow);
	}

	@Override
	public String toString() {
		return ")";
	}

}
