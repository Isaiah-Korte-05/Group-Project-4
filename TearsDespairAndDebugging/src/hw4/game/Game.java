package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.*;
import hw4.player.*;

public class Game {
	
	private Grid grid;
	
	/**
	 * Parameterized constructor to correspond a grid with this game
	 * @param grid A Grid in which the game uses
	 */
	public Game(Grid grid) {
		setGrid(grid);
	}
	
	/**
	 * Parameterized constructor to correspond a random grid of the given size with this game
	 * @param gridSize An int detailing the desired size of the game's grid
	 */
	public Game(int gridSize) {
		setGrid(createRandomGrid(gridSize));
	}

	/**
	 * Getter for the class member holding the game's Grid
	 * @return The Grid of the game
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Setter for the class member holding the game's Grid
	 * @param grid The Grid of the game
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Formats the Game class and its class member into a string
	 * @return The String formatting the class name and class member
	 */
	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
	/**
	 * Allows the player to move in the grid and play the game.
	 * @param movement A Movement enum detailing the desired direction of travel of the player
	 * @param player The Player that wants to move in the grid
	 * @return True if the Player and Movement choice are valid and the player has not yet exited, false otherwise
	 */
	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null) { return false; }
		if (player.hasExited()) { return false; }
		
		// Get player's current position in the grid
		ArrayList<Row> row = grid.getRows();
		int rowIndex = row.indexOf(player.getCurrentRow());
		int cellIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		if (rowIndex == -1 || cellIndex == -1) { return false; }
		Cell currentCell = player.getCurrentCell();
		
		// Decide if passed Movement is valid
		// If so, set player's position to their desired cell
		switch(movement) {
		case LEFT:
			// Player is in cell with exit on left
			if (currentCell.getLeft() == CellComponents.EXIT) {
				player.setHasExited(true);
				return true;
			}
			// Player has space to move left and is not on grid's left edge
			if (currentCell.getLeft() == CellComponents.APERTURE && cellIndex > 0) {
				player.getCurrentCell().setHasPlayer(false);
				player.setCurrentCell(row.get(rowIndex).getCells().get(cellIndex - 1));
				player.getCurrentCell().setHasPlayer(true);
				return true;
			}
			break;
		case RIGHT:
			// Player has space to move right and is not on grid's right edge
			if (currentCell.getRight() == CellComponents.APERTURE && cellIndex < row.get(rowIndex).getCells().size() - 1) {
				player.getCurrentCell().setHasPlayer(false);
				player.setCurrentCell(row.get(rowIndex).getCells().get(cellIndex + 1));
				player.getCurrentCell().setHasPlayer(true);
				return true;
			}
			break;
		case UP:
			// Player has space to move up and is not on grid's top edge
			if (currentCell.getUp() == CellComponents.APERTURE && rowIndex > 0) {
				Row nextRow = row.get(rowIndex - 1);
				player.setCurrentRow(nextRow);
				player.getCurrentCell().setHasPlayer(false);
				player.setCurrentCell(nextRow.getCells().get(cellIndex));
				player.getCurrentCell().setHasPlayer(true);
				return true;
			}
			break;
		case DOWN:
			// Player has space to move down and is not on grid's bottom edge
			if (currentCell.getDown() == CellComponents.APERTURE && rowIndex < row.size() - 1) {
				Row nextRow = row.get(rowIndex + 1);
				player.setCurrentRow(nextRow);
				player.getCurrentCell().setHasPlayer(false);
				player.setCurrentCell(nextRow.getCells().get(cellIndex));
				player.getCurrentCell().setHasPlayer(true);
				return true;
			}
			break;
		}
		return false;
	}
	
	/**
	 * Creates a Grid of a given size with randomly decided CellComponents for each cell
	 * @param size An int detailing the desired size (one side) of the square grid
	 * @return A Grid of the desired size with random maze setup
	 */
	public Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) { return null; }
		
		// Randomly decide the row in which the exit sits
		Random rand = new Random();
		ArrayList<Row> rows = new ArrayList<>();
		int exitRowIndex = rand.nextInt(size);
		
		// Generate Cell and Row ArrayLists with random CellComponents enums
		for (int rowIndex = 0; rowIndex < size; rowIndex++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for (int cellIndex = 0; cellIndex < size; cellIndex++) {
				CellComponents left;
				CellComponents right;
				CellComponents up;
				CellComponents down;
				
				// If first cell,
				if (cellIndex == 0) {
					// If random exit row matches, set as exit
					// Else set randomly
					left = (rowIndex == exitRowIndex) ? CellComponents.EXIT : getRandomCellComponent();
				}
				// Else set to same as right in left cell
				else {
					left = cells.get(cellIndex - 1).getRight();
				}
				// If in first row, set randomly
				if (rowIndex == 0) {
					up = getRandomCellComponent();
				}
				// Else set to same as down in above row
				else {
					up = rows.get(rowIndex - 1).getCells().get(cellIndex).getDown();
				}
				// Right and down set randomly
				right = getRandomCellComponent();
				down = getRandomCellComponent();
				
				// Creates new Cell
				Cell cell = new Cell(left, right, up, down);
				
				// While Cell does not have at least one aperture and one wall, re-randomly set CellComponents
				while (!(cell.hasAperture() && cell.hasWall())) {
					right = getRandomCellComponent();
					down = getRandomCellComponent();
					cell = new Cell(left, right, up, down);
				}
				cells.add(cell);
			}
			rows.add(new Row(cells));
		}
		return new Grid(rows);
	}
	
	/**
	 * Helper function that decides the CellComponent enum using the Random class
	 * @return A randomly decided CellComponent enum
	 */
	private CellComponents getRandomCellComponent() {
		Random rand = new Random();
		return rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
	}
	
	public void printBoard() {
		grid.printGrid();
		System.out.println();
	}

}
