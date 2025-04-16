package hw4.maze;

/**
 * Represents the different states that are possible for a cell component
 */
public enum CellComponents {
	
	/**
	 * A state where the player cannot pass through to the adjacent cell
	 */
	WALL,
	
	/**
	 * A state where the player can pass through to the adjacent cell
	 */
	APERTURE,
	
	/**
	 * A state where the player can pass through and represents the goal
	 */
	EXIT

}
