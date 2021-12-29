package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import dungeon.Room;
import dungeon.Tile;

public class HumanPlayer extends Player<character.Hero> {
	public HumanPlayer(character.Hero hero, Tile currentTile) {
		super(hero, currentTile);
	}

	public void grabItem(dungeon.Tile tile) {
		this.getChara().searchTile(tile);
	}

	public void useItem(inventory.Item item) {
		this.getChara().useItem(item);
	}

	public Map<String, Tile> listReachableTiles(List<Tile> reachableTiles) {
		Map<String, Tile> tiles = reachableTiles.stream().collect(Collectors.toMap(t -> t.toString(), Function.identity()));
		System.out.println("List of all reachable cases");
		tiles.forEach((key, value) -> System.out.println(key));
		return tiles;

	}

	public Tile chooseTile(Scanner scanner, Map<String, Tile> tiles) {
		// choose a tile with input
		Tile tile = null;
		while (tile == null) {
			System.out.print("Choose case: \n");
			tile = tiles.get(scanner.nextLine());
		}
		return tile;
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

		else if (tile.isStaircase()) {
			chooseToCrossStaircase(scanner);
		}

		// Check if move is possible
		else if (canGoTo(tile)) {
			goTo(tile);
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

	private void chooseToCrossStaircase(Scanner scanner) {
		System.out.println("Staircase");
		System.out.println("Do you want to go? [y/n]");
		String confirm = scanner.nextLine();
		if (confirm.toLowerCase().charAt(0) == 'y') {
			System.out.println("[up/down]");
			String choice = scanner.nextLine();
			if (choice.toLowerCase().charAt(0) == 'u') {
				goUp();
			} else {
				goDown();
			}
		}
	};

	private boolean confirmAttack(Scanner scanner) {
		System.out.println("Do you want to attack? [y/n]");
		String confirm = scanner.nextLine();
		if (confirm.toLowerCase().charAt(0) == 'y') {
			return true;
		}
		return false;

	}
	
	public void goUp() {
		
	}
	
	public void goDown() {
		
	}
	
	public boolean canGoStaircase(){
		return this.getChara().getInventory().has("Staircase");
	}
	
	public void goStaircase(Room adjRoom) {
		Tile tile = getCurrentTile();
		goTo(adjRoom.getTile(tile.getXPosition(), tile.getYPosition()));
		
	}

}
