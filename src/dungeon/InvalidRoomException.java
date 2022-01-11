package dungeon;

/**
 * Runtime exception when the room does not have the right format (e.g: is not a
 * rectangle)
 *
 * @author Mehdi
 *
 */
public class InvalidRoomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidRoomException(String message) {
		super(message);
	}

}
