package hw4.simulation;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.Row;
import hw4.player.Player;
import hw4.player.Movement;

public class Main {

	public static void main(String[] args) {
		
		int gridSize = 4;
		
		Game game = new Game(gridSize);
		
		Row playerRow = game.getGrid().getRows().get(gridSize - 1);
		Cell playerCell = playerRow.getCells().get(gridSize - 1);
		
		Player player = new Player(playerRow, playerCell);
				
		try (Scanner scanner = new Scanner(System.in)) {
			while(!(player.hasExited())) {
				
				game.printBoard();
				
				System.out.println("Please input Agent movement:");
				System.out.println("-----------------------------");
				System.out.println("UP [W]");
				System.out.println("DOWN [S]");
				System.out.println("LEFT [A]");
				System.out.println("RIGHT [D]");
				System.out.println("-----------------------------\n");
				
				String input = scanner.nextLine().toLowerCase();
				char move = input.charAt(0);
				
				Movement moveConvert = null;
				
				switch(move) {
				case 'w':
					moveConvert = Movement.UP;
					break;
				case 's':
					moveConvert = Movement.DOWN;
					break;
				case 'a':
					moveConvert = Movement.LEFT;
					break;
				case 'd':
					moveConvert = Movement.RIGHT;
					break;
				}
				
				if(!game.play(moveConvert, player)) {
					System.out.println("Invalid move, try again.\n");
				}
			}
		}
		
		
	}

}
