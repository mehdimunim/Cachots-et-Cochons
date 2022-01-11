package inventory;

/**
 * Exception when the inventory is full
 *
 * @author Mehdi
 *
 */
public class FullInventoryException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullInventoryException(String string) {
		super(string);
	}
}
