package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import dungeon.Tile;
import inventory.Item;

public class HumanPlayer extends Player<character.Hero> {
	public HumanPlayer(character.Hero hero, Tile currentTile) {
		super(hero, currentTile);
	}

	// public boolean choosesToGoStaircase() {
//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.println("Staircase");
//			System.out.println("Do you want to go? [y/n]");
//			String confirm = scanner.nextLine();
//			return confirm.toLowerCase().charAt(0) == 'y';
//		}
//
//	};
	@Override
	public boolean choosesToGoStaircase() {
		return true;
	}

	public Tile chooseTile(Scanner scanner, Map<String, Tile> tiles) {
		// choose a tile with input
		Tile tile = null;
		while (tile == null) {
			System.out.print("\nChoose tile: ");
			String formatInput = formatInputString(scanner.nextLine());
			tile = tiles.get(formatInput);
		}
		return tile;
	}

	private boolean confirmAttack(Scanner scanner) {
		System.out.print("Do you want to attack? [y/n] ");
		String confirm = scanner.nextLine();
		if (confirm.toLowerCase().charAt(0) == 'y') {
			return true;
		}
		return false;

	}

	public String formatInputString(String input) {
		/**
		 * Format user input and return the correct formatting for tiles, aka: (line,
		 * column) Accepted input for Tile: (line, column) linecolumn if line and column
		 * are one digit line,column
		 *
		 */
		String fInput = input.strip();
		int length = input.length();

		if (length == 2) {
			fInput = fInput.charAt(0) + "," + fInput.charAt(1);
		}
		if (fInput.charAt(0) != '(') {
			fInput = '(' + fInput;
		}
		if (fInput.charAt(length - 1) != ')') {
			fInput = fInput + ')';
		}
		return fInput;
	}

	public void grabItem(Tile tile) {
		getChara().searchTile(tile);
	}

	public Map<String, Tile> listReachableTiles(List<Tile> reachableTiles) {
		System.out.println("List of all reachable cases: ");
		reachableTiles.stream().sorted().forEachOrdered(tile -> System.out.println(tile.toString()));
		return reachableTiles.stream().collect(Collectors.toMap(t -> t.toString(), Function.identity()));

	}

	@Override
	public void play(List<Tile> reachableTiles) {
		// List all tiles to human
		Map<String, Tile> tiles = listReachableTiles(reachableTiles);

		// Let human choose a tile
		Scanner scanner = new Scanner(System.in);
		Tile tile = chooseTile(scanner, tiles);

		// if no reachable tile, do nothing
		if (reachableTiles.isEmpty()) {
			System.out.println("No move possible");
		}

		// Check if move is possible
		else if (canGoTo(tile)) {
			goTo(tile);
			if (tile.hasItem()) {
				grabItem(tile);
			}
		}

		// else if can attack
		else if (canAttack(tile)) {
			// confirm attack
			if (confirmAttack(scanner)) {
				attack(tile);
			} else {
				System.out.println("Attack aborted");
				play(reachableTiles);
			}

			// else choose another tile
		} else {
			System.out.println("Tile blocked");
			reachableTiles.remove(tile);
			play(reachableTiles);
		}

	}

	public void useItem(Item item) {
		getChara().useItem(item);
	}

}
