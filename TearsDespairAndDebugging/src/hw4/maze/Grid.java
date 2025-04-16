package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Row> rows;
	
	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

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
