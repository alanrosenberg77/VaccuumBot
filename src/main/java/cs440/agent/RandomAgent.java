package cs440.agent;

import cs440.util.Action;

public class RandomAgent extends Agent {

	/**
	 * Simply chooses a random action to take
	 * 
	 * @return random action
	 */
	@Override
	public String[] decide() {
		
		String[] actions = new String[1];
		actions[0] = Action.randomAction();
		return actions;
	}

}
