package main;

import dungeon.Room;

public class GoStaircaseCommand<T extends character.Character> implements Command {
	private Player<T> player;
	private Room adjRoom;
	
	public GoStaircaseCommand(Player<T> player, Room adjRoom) {
		this.player = player;
		this.adjRoom = adjRoom;
	}
	
	@Override
	public void execute() {
		player.goStaircase(adjRoom);
	}

}
