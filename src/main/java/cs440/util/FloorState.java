package cs440.util;

public class FloorState {
	
	private final static int DIMENSION = 5;
	
	private char[][] tiles;
	
	/**
	 * displayString displays the current floor state in the form of a
	 * formatted string
	 * 
	 * @return graphical representation of floor state
	 */
	public String displayString() {
		return null;
		// TODO displayString()
	}
	
	/**
	 * Flattens the 2D array of tiles into a single string
	 * 
	 * @return flattened representation of floor state
	 */
	public String toString() {
		return null;
		// TODO toString()
	}
	
	/*
	 * Convenient constructors
	 */
	public FloorState() {
		super();
	}
	
	public FloorState(String floor) {
		super();
		setTilesFromString(floor);
	}
	
	/*
	 * getters and setters for tiles
	 */
	private char[][] getTiles() {
		return tiles;
	}
	
	private void setTiles(char[][] fromString) {
		tiles = fromString;
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

	/**
	 * Creates a new character array that represents the floor state
	 * from a string
	 * 
	 * @param tStr
	 * @return
	 */
	public char[][] fromString(String tStr) {
		return null;
		// TODO fromString()
	}
	
	/**
	 * Creates and returns a new floor state object based on the current
	 * state if a provided action is taken.
	 * 
	 * @param a action
	 * @return FloorState new floor state based on current
	 * once the action is taken
	 */
	public FloorState nextStateFromAction(Action a) {
		return null;
		// TODO nextStateFromAction()
	}
	
	/**
	 * Determines whether the floor is currently clean, meaning
	 * there is no more dirt on the floor
	 * 
	 * @return true is clean, false is not
	 */
	public boolean isClean() {
		return false;
		// TODO isClean()
	}

}
