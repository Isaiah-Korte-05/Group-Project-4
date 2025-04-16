package hw4.game;

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
		return new Grid();
	}

}
