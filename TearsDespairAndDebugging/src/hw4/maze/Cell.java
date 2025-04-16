package hw4.maze;

public class Cell {
	
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public CellComponents getLeft() {
		return left;
	}

	public CellComponents getRight() {
		return right;
	}

	public CellComponents getUp() {
		return up;
	}

	public CellComponents getDown() {
		return down;
	}
	
	public void setLeft(CellComponents left) {
		if (left != null) { this.left = left; }
		else { this.left = CellComponents.WALL; }
	}
	
	public void setRight(CellComponents right) {
		if (right != null) { this.right = right; }
		else { this.right = CellComponents.WALL; }
	}
	
	public void setUp(CellComponents up) {
		if (up != null) { this.up = up; }
		else { this.up = CellComponents.WALL; }
	}

	public void setDown(CellComponents down) {
		if (down != null) { this.down = down; }
		else { this.down = CellComponents.WALL; }
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	public boolean hasAperture() {
		if (left == CellComponents.APERTURE ||
			right == CellComponents.APERTURE ||
			up == CellComponents.APERTURE ||
			down == CellComponents.APERTURE) {
			return true;
		}
		return false;
	}
	
	public boolean hasWall() {
		if (left == CellComponents.WALL ||
			right == CellComponents.WALL ||
			up == CellComponents.WALL ||
			down == CellComponents.WALL) {
			return true;
		}
		return false;
	}

}
