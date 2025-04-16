package hw4.player;

import hw4.maze.*;

public class Player {
	
	/**
	 * Holds the row in which the player currently sits
	 */
	private Row currentRow;
	/**
	 * Holds the cell in the current row in which the player currently sits
	 */
	private Cell currentCell;
	/**
	 * Holds the state of if the player has exited and finished the maze and is initially false
	 */
	private boolean hasExited = false;
	
	/**
	 * Parameterized constructor to set the position in which the player sits
	 * @param row Row in which the player sits
	 * @param cell Cell in which the player sits
	 */
	public Player(Row row, Cell cell) {
		setCurrentRow(row);
		setCurrentCell(cell);
	}

	/**
	 * Getter for the class member holding the row in which the player currently sits
	 * @return The Row in which the player currently sits
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	/**
	 * Setter for the class member holding the row in which the player currently sits
	 * @param currentRow The new Row in which the player currently sits
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * Getter for the class member holding the cell in which the player currently sits
	 * @return The Cell in which the player currently sits
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * Setter for the class member holding the cell in which the player currently sits
	 * @param currentCell The new Cell in which the player currently sits
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	/**
	 * Formats the Player class and its class members into a string
	 * @return The String formatting the class name and class members holding the row and cell in which the player currently sits
	 */
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

	/**
	 * Getter for the class member holding the state of if the player has exited the maze
	 * @return True if the player has exited, false if the player has not yet exited
	 */
	public boolean hasExited() {
		return hasExited;
	}

	/**
	 * Setter for the class member holding the state of if the player has exited the maze
	 * @param hasExited The state of if the player has exited
	 */
	public void setHasExited(boolean hasExited) {
		this.hasExited = hasExited;
	}

}
