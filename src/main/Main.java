package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("The game starts");
		
		System.out.println("*".repeat(50));
		for (int i=0; i<=50;i++) {
			System.out.print("*" +" ".repeat(49) + "*\n");
		}
		
		int dungeon_dim = 100;
		
		Room room = Room.create();
		
		RoomDisplayer rDisp = RoomDisplayer.get(dungeon_dim);
		
		rDisp.display(dungeon);
			
		display(room);

	}

}
