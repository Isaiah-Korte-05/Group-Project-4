package hw4.maze;

public class Cell {
	
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	private boolean hasPlayer;
	
	/**
	 * Parameterized constructor to set the states of the components of this cell
	 * @param left The state of the left component of the cell given by a CellComponents enum
	 * @param right The state of the right component of the cell given by a CellComponents enum
	 * @param up The state of the upper component of the cell given by a CellComponents enum
	 * @param down The state of the lower component of the cell given by a CellComponents enum
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	/**
	 * Getter for the class member holding the CellComponents enum of the left component of the cell
	 * @return The left CellComponent enum
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * Getter for the class member holding the CellComponents enum of the right component of the cell
	 * @return The right CellComponent enum
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Getter for the class member holding the CellComponents enum of the upper component of the cell
	 * @return The upper CellComponent enum
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Getter for the class member holding the CellComponents enum of the lower component of the cell
	 * @return The lower CellComponent enum
	 */
	public CellComponents getDown() {
		return down;
	}
	
	
	public boolean getHasPlayer() {
		return hasPlayer;
	}
	
	/**
	 * Setter for the class member holding the CellComponents enum of the left component of the cell
	 * @param left The new state for left CellComponent enum
	 */
	public void setLeft(CellComponents left) {
		if (left != null) { this.left = left; }
		else { this.left = CellComponents.WALL; }
	}
	
	/**
	 * Setter for the class member holding the CellComponents enum of the right component of the cell
	 * @param right The new state for right CellComponent enum
	 */
	public void setRight(CellComponents right) {
		if (right != null) { this.right = right; }
		else { this.right = CellComponents.WALL; }
	}
	
	/**
	 * Setter for the class member holding the CellComponents enum of the upper component of the cell
	 * @param up The new state for upper CellComponent enum
	 */
	public void setUp(CellComponents up) {
		if (up != null) { this.up = up; }
		else { this.up = CellComponents.WALL; }
	}

	/**
	 * Setter for the class member holding the CellComponents enum of the lower component of the cell
	 * @param down The new state for lower CellComponent enum
	 */
	public void setDown(CellComponents down) {
		if (down != null) { this.down = down; }
		else { this.down = CellComponents.WALL; }
	}
	
	public void setHasPlayer(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}

	/**
	 * Formats the Cell class and its class members into a string
	 * @return The String formatting the class name and class members holding the four CellComponents of the cell
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	/**
	 * Relays the state information of if this cell has at least one aperture CellComponents
	 * @return True if the cell has at least one aperture, false otherwise
	 */
	public boolean hasAperture() {
		if (left == CellComponents.APERTURE ||
			right == CellComponents.APERTURE ||
			up == CellComponents.APERTURE ||
			down == CellComponents.APERTURE) {
			return true;
		}
		return false;
	}
	
	/**
	 * Relays the state information of if this cell has at least one wall CellComponents
	 * @return True if the cell has at least one wall, false otherwise
	 */
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
