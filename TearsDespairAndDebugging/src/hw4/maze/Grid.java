package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Row> rows;
	
	/**
	 * Parameterized constructor to correspond an ArrayList of rows with this grid
	 * @param rows A Row ArrayList in which the grid holds
	 */
	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	/**
	 * Getter for the class member holding the grid's Row ArrayList
	 * @return The Row ArrayList of the grid
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

	/**
	 * Setter for the class member holding the grid's Row ArrayList
	 * @param rows The Row ArraList of the grid
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * Formats the Grid class and its class member into a string
	 * @return The String formatting the class name and class member
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
	
	public void printGrid() {
		System.out.println("---------------\n CURRENT GRID\n---------------");
		for(int i = 0; i < rows.size(); i++) {
			for(int j = 0; j < rows.get(i).getCells().size(); j++) {
				if(rows.get(i).getCells().get(j).getLeft() == CellComponents.EXIT) {
					System.out.print(" E ");
				}
				else if(rows.get(i).getCells().get(j).getHasPlayer()) {
					System.out.print("[A]");
				}
				else {
					System.out.print(" S ");
				}
			}
			System.out.println();
		}
	}

}
