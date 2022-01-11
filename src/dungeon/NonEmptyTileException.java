package dungeon;

/**
 * Exception when tile already has a character
 *
 * @author Mehdi
 *
 */
public class NonEmptyTileException extends Exception {
	private static final long serialVersionUID = 1L;

	public NonEmptyTileException(String string) {
		super(string);
	}

}
