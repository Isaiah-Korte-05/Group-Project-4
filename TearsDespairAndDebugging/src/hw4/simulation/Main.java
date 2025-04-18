package hw4.simulation;

import java.util.ArrayList;
import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;
import hw4.player.Movement;

public class Main {

	public static void main(String[] args) {
		
//		int gridSize = 4;
//		
//		Game game = new Game(gridSize);
//		
//		Row playerRow = game.getGrid().getRows().get(gridSize - 1);
//		Cell playerCell = playerRow.getCells().get(gridSize - 1);
//		
//		Player player = new Player(playerRow, playerCell);
//		
//		Row playerRow = game.getGrid().getRows().get(gridSize - 1);
//		Cell playerCell = playerRow.getCells().get(gridSize - 1);
//		
//		Player player = new Player(playerRow, playerCell);
		
		Cell cell00 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell01 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell02 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell10 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell11 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell12 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell20 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell21 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell22 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);


		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(0, cell00);
		cells.add(1, cell01);
		cells.add(2, cell02);
		Row row0 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell10);
		cells.add(1, cell11);
		cells.add(2, cell12);
		Row row1 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell20);
		cells.add(1, cell21);
		cells.add(2, cell22);
		Row row2 = new Row(cells);

		ArrayList<Row> rows = new ArrayList<Row>();
		rows.add(0, row0);
		rows.add(1, row1);
		rows.add(2, row2);
		Game game = new Game(new Grid(rows));
		Player player = new Player(game .getGrid().getRows().get(2), 
				game.getGrid().getRows().get(2).getCells().get(2));
				
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
				if(input.length() == 0) {
					System.out.println("Invalid move, try again.\n");
					continue;
				}
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
				
				if(player.hasExited()) {break;}
			}
		}
		
		System.out.println("YAY! YOU ESCAPED!");
		
	}

}
