package main;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import character.Character;
import dungeon.Tile;

public class AIPlayer extends Player<character.Character> {

	public AIPlayer(Character chara, Tile currentTile) {
		super(chara, currentTile);
	}

	@Override
	public void play(List<Tile> reachableTiles) {

		// choose one tile randomly
		Random rand = new Random();
		Tile randomTile = reachableTiles.get(rand.nextInt(reachableTiles.size()));
		
		Optional<Character> chara = randomTile.getCharacter();
		
		// if no tile is reachable do nothing 
		
		if (reachableTiles.isEmpty()) {
			
		}
		// if no character, move to the tile
		else if (chara.isEmpty()) {
			this.goTo(randomTile);
		}

		// else if there is an enemy, attack
		else if (chara.get().isEnnemyWith(this.getChara())) {
			this.getChara().attack(chara.get());
		}

		// else if there is ally, redo without the tile picked up
		else { 
		reachableTiles.remove(randomTile);
		play(reachableTiles);
		}
		
		}

	@Override
	protected boolean choosesToGoStaircase() {
		// an AI Player never crosses a staircase
		return false;
	}


	}


