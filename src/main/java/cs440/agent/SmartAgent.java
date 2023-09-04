package cs440.agent;

import cs440.util.Action;

public class SmartAgent extends Agent {

	private String patrolLong;
	private String patrolLat;

	public SmartAgent() {
		super();
		patrolLong = Action.RIGHT;
		patrolLat = Action.DOWN;
	}

	@Override
	public String[] decide() {

		String[] actions;

		if (checkHere()) {
			actions = new String[1];
			actions[0] = Action.SUCK;
		} else if (checkUp()) {
			actions = new String[3];
			actions[0] = Action.UP;
			actions[1] = Action.SUCK;
			actions[2] = Action.DOWN;
		} else if (checkDown()) {
			actions = new String[3];
			actions[0] = Action.DOWN;
			actions[1] = Action.SUCK;
			actions[2] = Action.UP;
		} else
			return patrol();

		return actions;
	}

	/**
	 * <i>patrol</i> is a background function in which the bot will continuously
	 * snake through the environment, looking for dirty floor tiles. It simply
	 * commands the bot to move so that it may use its percepts to view new tiles
	 * and possibly find more dirty ones.
	 */
	private String[] patrol() {

		String actions[] = new String[1];

		// if patroling right...
		if (patrolLong.equals("RIGHT")) {
			// and able to go right...
			if (col < current.getTiles().length - 1) {
				// go right
				actions[0] = patrolLong;
			}

			// but unable to go right...
			else {
				patrolLong = oppositeOf(patrolLong); // start patroling left

				// if patroling down...
				if (patrolLat.equals("DOWN")) {
					// and able to go down...
					if (row < current.getTiles().length - 1) {
						// go down
						actions[0] = patrolLat;
					}
					// otherwise...
					else {
						// start patroling up
						patrolLat = oppositeOf(patrolLat);
						actions[0] = patrolLat;
					}
				}

				// if patroling up...
				else {
					// and able to go up...
					if (row > 0) {
						// go up
						actions[0] = patrolLat;
					}
					// otherwise...
					else {
						// start patroling down
						patrolLat = oppositeOf(patrolLat);
						actions[0] = patrolLat;
					}
				}
			}
		}

		// if patroling left...
		else {
			// and able to go left...
			if (col > 0) {
				// go left
				actions[0] = patrolLong;
			}

			// but unable to go left...
			else {
				patrolLong = oppositeOf(patrolLong); // start patroling right

				// if patroling down...
				if (patrolLat.equals("DOWN")) {
					// and able to go down...
					if (row < current.getTiles().length - 1) {
						// go down
						actions[0] = patrolLat;
					}
					// otherwise...
					else {
						// start patroling up
						patrolLat = oppositeOf(patrolLat);
						actions[0] = patrolLat;
					}
				}

				// if patroling up...
				else {
					// and able to go up...
					if (row > 0) {
						// go up
						actions[0] = patrolLat;
					}
					// otherwise...
					else {
						// start patroling down
						patrolLat = oppositeOf(patrolLat);
						actions[0] = patrolLat;
					}
				}
			}
		}

		return actions;

	}

	/**
	 * Percept for the bot's tile
	 * 
	 * @return true if dirty, false if clean
	 */
	private boolean checkHere() {

		char here = current.getTiles()[row][col];

		if (here == '1')
			return true;
		else
			return false;
	}

	/**
	 * Percept for the tile above the bot
	 * 
	 * @return true if dirty, false if clean
	 */
	private boolean checkUp() {

		char up;

		try {
			up = current.getTiles()[row - 1][col];
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

		if (up == '1')
			return true;
		else
			return false;
	}

	/**
	 * Percept for the tile below the bot
	 * 
	 * @return true if dirty, false if clean
	 */
	private boolean checkDown() {

		char down;

		try {
			down = current.getTiles()[row + 1][col];
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

		if (down == '1')
			return true;
		else
			return false;
	}

	/**
	 * Helper to return the opposite of a directional action
	 * 
	 * @param original action
	 * @return opposite action
	 */
	private String oppositeOf(String action) {

		if (action.equals("UP"))
			return Action.DOWN;
		if (action.equals("RIGHT"))
			return Action.LEFT;
		if (action.equals("DOWN"))
			return Action.UP;
		if (action.equals("LEFT"))
			return Action.RIGHT;

		return null;
	}

}
