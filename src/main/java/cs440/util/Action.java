package cs440.util;

public interface Action {

	public final static String SUCK = "SUCK";
	public final static String DO_NOTHING = "DO_NOTHING";
	public final static String UP = "UP";
	public final static String RIGHT = "RIGHT";
	public final static String DOWN = "DOWN";
	public final static String LEFT = "LEFT";
	
	public final static String[] ALL = {SUCK, DO_NOTHING, UP, RIGHT, DOWN, LEFT};
	
	/**
	 * Randomly returns action from collection
	 * 
	 * @return Action random action
	 */
	public static String randomAction() {
		return ALL[(int) (Math.random()*6)];
	}
	
}
