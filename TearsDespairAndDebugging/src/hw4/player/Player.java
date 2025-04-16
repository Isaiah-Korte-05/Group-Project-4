package hw4.player;

import hw4.maze.*;

public class Player {
	
	private Row currentRow;
	private Cell currentCell;
	private boolean hasExited = false;
	
	public Player(Row row, Cell cell) {
		setCurrentRow(row);
		setCurrentCell(cell);
		cell.setHasPlayer(true);
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

	public boolean hasExited() {
		return hasExited;
	}

	public void setHasExited(boolean hasExited) {
		this.hasExited = hasExited;
	}

}
