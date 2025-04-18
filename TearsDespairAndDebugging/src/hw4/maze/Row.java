package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	private ArrayList<Cell> cells;
	
	/**
	 * Parameterized constructor to correspond an ArrayList of cells with this row
	 * @param cells A Cell ArrayList in which the row holds
	 */
	public Row(ArrayList<Cell> cells) {
		setCells(cells);
	}

	/**
	 * Getter for the class member holding the row's Cell ArrayList
	 * @return The Cell ArrayList of the row
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * Setter for the class member holding the row's Cell ArrayList
	 * @param cells The Cell ArraList of the row
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Formats the Row class and its class member into a string
	 * @return The String formatting the class name and class member
	 */
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}

}
