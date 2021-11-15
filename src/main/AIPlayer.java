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
		//generate all reachable tiles for AI player
		
		//choose one randomly
		Random rand = new Random();
	    Tile randomTile = reachableTiles.get(rand.nextInt(reachableTiles.size()));
		
	    Optional<Character> chara = randomTile.getCharacter();
	    
	    
	    
	    // if no character, move to the tile
	    if (chara.isEmpty()) {
	    	this.move(randomTile);
	    }
	    
	    // else if there is an enemy, attack
	    else if (chara.get().isEnnemyWith(this.getChara())) {
	    	this.getChara().attack(chara.get());
	    }
	    
	    //else if there is ally, redo
	    else {
	    	this.play(reachableTiles);
	    }
	    

	}

}
