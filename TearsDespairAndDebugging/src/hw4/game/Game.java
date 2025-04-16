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
		
		if (player.hasExited()) { return false; }
		
		ArrayList<Row> row = grid.getRows();
		int rowIndex = row.indexOf(player.getCurrentRow());
		int cellIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		if (rowIndex == -1 || cellIndex == -1) { return false; }
		
		Cell currentCell = player.getCurrentCell();
		
		switch(movement) {
		case LEFT:
			if (currentCell.getLeft() == CellComponents.EXIT) {
				player.setHasExited(true);
				return true;
			}
			if (currentCell.getLeft() == CellComponents.APERTURE && cellIndex > 0) {
				player.setCurrentCell(row.get(rowIndex).getCells().get(cellIndex - 1));
				return true;
			}
			break;
		case RIGHT:
			if (currentCell.getRight() == CellComponents.APERTURE && cellIndex < row.get(rowIndex).getCells().size() - 1) {
				player.setCurrentCell(row.get(rowIndex).getCells().get(cellIndex + 1));
				return true;
			}
			break;
		case UP:
			if (currentCell.getUp() == CellComponents.APERTURE && rowIndex > 0) {
				Row nextRow = row.get(rowIndex - 1);
				player.setCurrentRow(nextRow);
				player.setCurrentCell(nextRow.getCells().get(cellIndex));
				return true;
			}
			break;
		case DOWN:
			if (currentCell.getDown() == CellComponents.APERTURE && rowIndex < row.size() - 1) {
				Row nextRow = row.get(rowIndex + 1);
				player.setCurrentRow(nextRow);
				player.setCurrentCell(nextRow.getCells().get(cellIndex));
				return true;
			}
			break;
		}
		return false;
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
