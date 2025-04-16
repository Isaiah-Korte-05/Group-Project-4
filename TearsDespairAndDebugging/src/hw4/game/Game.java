package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.*;
import hw4.player.*;

public class Game {
	
	private Grid grid;
	
	public Game(Grid grid) {
		setGrid(grid);
	}
	
	public Game(int gridSize) {
		setGrid(createRandomGrid(gridSize));
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
	
	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null) { return false; }
		return true;
	}
	
	public Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) { return null; }
		
		Random rand = new Random();
		ArrayList<Row> rows = new ArrayList<>();
		int exitRowIndex = rand.nextInt(size);
		for (int rowIndex = 0; rowIndex < size; rowIndex++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for (int cellIndex = 0; cellIndex < size; cellIndex++) {
				CellComponents left;
				CellComponents right;
				CellComponents up;
				CellComponents down;
				if (cellIndex == 0) {
					left = rowIndex == exitRowIndex ? CellComponents.EXIT : getRandomCellComponent();
				}
				else {
					left = cells.get(cellIndex - 1).getRight();
				}
				if (rowIndex == 0) {
					up = getRandomCellComponent();
				}
				else {
					up = rows.get(rowIndex - 1).getCells().get(cellIndex).getDown();
				}
				right = getRandomCellComponent();
				down = getRandomCellComponent();
				Cell cell = new Cell(left, right, up, down);
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
	
	private CellComponents getRandomCellComponent() {
		Random rand = new Random();
		return rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
	}

}
