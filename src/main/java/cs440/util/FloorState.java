package cs440.util;

import cs440.agent.Agent;

public class FloorState {

	private final static int DIMENSION = 5;
	private Agent bot;

	private char[][] tiles;

	/**
	 * displayString displays the current floor state in the form of a formatted
	 * string
	 * 
	 * @return graphical representation of floor state
	 */
	public String displayString() {

		StringBuffer buf = new StringBuffer("+-----+\n");

		for (int r = 0; r < DIMENSION; r++) {
			buf.append("|");
			for (int c = 0; c < DIMENSION; c++) {
				buf.append(tiles[r][c]);
			}
			buf.append("|");
			buf.append("\n");
		}

		buf.append("+-----+\n");

		return buf.toString();
	}

	/**
	 * Flattens the 2D array of tiles into a single string
	 * 
	 * @return flattened representation of floor state
	 */
	public String toString() {

		StringBuffer buf = new StringBuffer();
		for (int r = 0; r < DIMENSION; r++) {
			for (int c = 0; c < DIMENSION; c++) {
				buf.append(tiles[r][c]);
			}
		}
		return buf.toString();
	}

	/*
	 * Convenient constructors
	 */
	public FloorState(char[][] tiles) {
		this.tiles = tiles;
	}

	public FloorState(Agent bot) {
		this.bot = bot;
	}

	public FloorState(Agent bot, String floor) {
		this.bot = bot;
		setTilesFromString(floor);
	}

	public FloorState(Agent bot, char[][] tiles) {
		this.bot = bot;
		this.tiles = tiles;
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
	 * Uses a string to conveniently initialize our 2D array of characters. For
	 * programmers convenience.
	 * 
	 * @param tStr
	 */
	public void setTilesFromString(String tStr) {
		this.setTiles(fromString(tStr));
	}

	/**
	 * Creates a new character array that represents the floor state from a string
	 * 
	 * @param tStr
	 * @return
	 */
	public char[][] fromString(String tStr) {

		/*
		 * make sure we have a NxN size string
		 */
		assert (tStr.length() == DIMENSION * DIMENSION);

		/*
		 * We will generate an NxN char array
		 */
		char[][] t = new char[DIMENSION][DIMENSION];

		/*
		 * Copy each character over
		 */
		for (int r = 0; r < DIMENSION; r++) {
			for (int c = 0; c < DIMENSION; c++) {
				t[r][c] = tStr.charAt(r * DIMENSION + c);
			}
		}

		return t;
	}

	/**
	 * Searches the array and returns the current row position of the bot
	 * 
	 * @return int row index of the bot
	 */
	public int botRow() {
		for (int r = 0; r < DIMENSION; r++) {
			if (r == bot.getRow()) {
				return r;
			}
		}

		return -1;
	}

	/**
	 * Searches the array and returns the current col position of the bot
	 * 
	 * @return int col index of the bot
	 */
	public int botCol() {
		for (int c = 0; c < DIMENSION; c++) {
			if (c == bot.getCol()) {
				return c;
			}
		}

		return -1;
	}
	
	/**
	 * determines whether the action is valid given the current floor state
	 * 
	 * @param action
	 * @return true if valid
	 * @throws InvalidActionException if invalid
	 */
	public boolean isValidAction(String action) throws InvalidActionException {
		
		/*
		 * When the action is up, this if statement will execute the algorithm for
		 * moving the blank up. It will also check if the blank is already as high up in
		 * the puzzle as it can be. If so, the method will return null.
		 */
		if (action.equals("UP")) {

			int y = botRow();
			if (y == 0) // throwing exception if action is invalid
				throw new InvalidActionException("Can't go" + action);
			else
				return true;
		}
		
		/*
		 * Repeating for down action
		 */
		if (action.equals("DOWN")) {

			int y = botRow();
			if (y == 4)
				throw new InvalidActionException("Can't go" + action);
			else
				return true;
		}
		
		/*
		 * Repeating for left action
		 */
		if (action.equals("LEFT")) {

			int x = botCol();
			if (x == 0)
				throw new InvalidActionException("Can't go" + action);
			else
				return true;
		}
		
		/*
		 * Repeating for right action
		 */
		if (action.equals("RIGHT")) {

			int x = botCol();
			if (x == 4)
				throw new InvalidActionException("Can't go" + action);
			else
				return true;
		}
		
		return false;
	}

	/**
	 * Creates and returns a new floor state object based on the current state if a
	 * provided action is taken.
	 * 
	 * @param a action
	 * @return FloorState new floor state based on current once the action is taken
	 */
	public FloorState nextStateFromAction(String action) {

		char[][] newTiles = new char[DIMENSION][DIMENSION];
		for (int x = 0; x < DIMENSION; x++) {
			for (int y = 0; y < DIMENSION; y++) {
				newTiles[x][y] = tiles[x][y]; // making new copy of tiles
			}
		}

		/*
		 * When the action is SUCK, changes the tile to clean (0)
		 */
		if (action.equals("SUCK")) {

			int x = bot.getCol();
			int y = bot.getRow();
			
			tiles[y][x] = '0';	//"cleaning"
		}
		
		/*
		 * SUCK is the only action that will augment the tiles, so we are done
		 */

		return new FloorState(newTiles); // returning new floor state
	}

	/**
	 * Determines whether the floor is currently clean, meaning there is no more
	 * dirt on the floor
	 * 
	 * @return true is clean, false is not
	 */
	public boolean isClean() {
		
		boolean clean = true;
		for(int c = 0 ; c < tiles.length ; c++) {
			for(int r = 0 ; r < tiles[0].length ; r++) {
				if(tiles[r][c] == '1') {
					clean = false;
				}
			}
		}
		
		return clean;
	}

}
