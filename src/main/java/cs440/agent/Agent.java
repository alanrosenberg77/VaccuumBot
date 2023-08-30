package cs440.agent;

import cs440.util.FloorState;

/**
 * An instance of this interface will be capable of discerning the information
 * about the agent's environment gathered by sensors. It will also be capable
 * of interacting with the environment using its actuators. The agents will
 * make decisions based on the state of its environment and the condition-action
 * rules given to it.
 * 
 * @author alanr
 *
 */
public abstract class Agent {
	
	//Start and end states of the floor
	protected FloorState start;
	protected FloorState goal;

	/*
	 * Setters for start and goal
	 */
	
	public void setStartState(FloorState start) {
		this.start = start;
	}
	
	public void setGoalState(FloorState goal) {
		this.goal = goal;
	}
	
	/*
	 * decide will determine what the agent does next
	 * whether that is suck, do nothing, or move up, down, left, or right
	 */
	public abstract void decide();
}
