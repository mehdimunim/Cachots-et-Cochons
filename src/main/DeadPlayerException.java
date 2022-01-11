package main;

/**
 * Exception when the human player is dead
 *
 * @author Mehdi
 *
 */
public class DeadPlayerException extends Exception {
	private static final long serialVersionUID = 1L;

	public void printMessage() {
		System.err.println("\nYOU ARE DEAD");
	}

}
