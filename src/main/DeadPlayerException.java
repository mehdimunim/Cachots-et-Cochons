package main;

public class DeadPlayerException extends Exception {
	private static final long serialVersionUID = 1L;

		public void printMessage() {
			System.err.println("\nYOU ARE DEAD");
		}

	}

