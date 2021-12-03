package main;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	@Override
	public void play(List<Tile> reachableTiles) {
		System.out.println("Choose case");
		// List all tiles to human
		var tiles = reachableTiles.stream().collect(Collectors.toMap(t -> t.toString(), Function.identity()));
		System.out.println("List of all reachable Cases");
		tiles.forEach((key, value) -> System.out.println(key));
		
		// Read input
		Scanner scanner = new Scanner(System.in);
		Tile tile = tiles.get(scanner.nextLine());

		// Check if move is possible
		if (this.canGoTo(tile)) {
			this.goTo(tile);
		}
		
		// else if can attack
		else if (this.canAttack(tile)) {
			// confirm attack
			if (confirmAttack(scanner)) {
				this.attack(tile);
			} else {
				System.out.println("Attack aborted");
				play(reachableTiles);
			}

		//else choose another tile
		} else {
			System.out.println("Tile blocked");
			play(reachableTiles);
		}

	}

	private boolean confirmAttack(Scanner scanner) {
		System.out.println("Do you want to attack? [y/n]");
		String confirm = scanner.nextLine();
		if (confirm.toLowerCase().equals('y')) {
			return true;
		}
		return false;

	}

}
