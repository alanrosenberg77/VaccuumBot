package cs440.util;

public class FloorState {
	
	private final static int DIMENSION = 5;
	
	private char[][] tiles;
	
	/**
	 * displayString displays the current floor state in the form of a
	 * formatted string
	 * 
	 * @return String graphical representation of floor state
	 */
	public String displayString() {
		return null;
		// TODO displayString()
	}
	
	/**
	 * Flattens the 2D array of tiles into a single string
	 * 
	 * @return String flattened representation of floor state
	 */
	public String toString() {
		return null;
		// TODO toString()
	}
	
	public FloorState() {
		super();
	}
	
	public FloorState(String floor) {
		super();
		setTilesFromString(floor);
	}
	
	/**
	 * Uses a string to conveniently initialize our 2D array of
	 * characters.  For programmers convenience.
	 *  
	 * @param tStr
	 */
	public void setTilesFromString(String tStr) {
		this.setTiles(fromString(tStr));
	}
	
	private char[][] getTiles() {
		return tiles;
	}
	
	private void setTiles(char[][] fromString) {
		tiles = fromString;
	}

	/**
	 * 
	 * @param tStr
	 * @return
	 */
	public char[][] fromString(String tStr) {
		return tiles;
		// TODO fromString()
	}

}
