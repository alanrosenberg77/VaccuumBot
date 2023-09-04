package cs440.agent;

import cs440.util.Action;
import cs440.util.FloorState;
import cs440.util.InvalidActionException;

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
	protected FloorState current;
	protected FloorState goal;
	protected int row;
	protected int col;

	/*
	 * Setters for start and goal
	 */
	
	public void setCurrentState(FloorState current) {
		this.current = current;
	}
	
	public void setGoalState(FloorState goal) {
		this.goal = goal;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCoords(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * act will actually perform the agent's decided action.
	 * It is dependent on the floor state to allow or disallow
	 * the chosen action. For example, if the agent is on the
	 * right barrier of the floor and tries to move right, the
	 * floor state will disallow the action.
	 * 
	 * @param chosen action
	 */
	public FloorState act(String action) {
		
		if(action.equals("UP")) {
			
			try {
				if(current.isValidAction(action)) {
					
					//Moving bot up one row and returning unchanged floor state
					row--;
					return current;
				}
			}
			catch (InvalidActionException e) {
				
				//staying put and returning unchanged floor state
				return current;
			}
		}
		
		if(action.equals("LEFT")) {
			
			try {
				if(current.isValidAction(action)) {
					
					//Moving bot left one col and returning unchanged floor state
					col--;
					return current;
				}
			}
			catch (InvalidActionException e) {
				
				//staying put and returning unchanged floor state
				return current;
			}
		}
		
		if(action.equals("DOWN")) {
			
			try {
				if(current.isValidAction(action)) {
					
					//Moving bot down one row and returning unchanged floor state
					row++;
					return current;
				}
			}
			catch (InvalidActionException e) {
				
				//staying put and returning unchanged floor state
				return current;
			}
		}
		
		if(action.equals("RIGHT")) {
			
			try {
				if(current.isValidAction(action)) {
					
					//Moving bot right one col and returning unchanged floor state
					col++;
					return current;
				}
			}
			catch (InvalidActionException e) {
				
				//staying put and returning unchanged floor state
				return current;
			}
		}
		
		if(action.equals("SUCK")) {
			
			return current.nextStateFromAction(action);
		}
		
		if(action.equals("DO_NOTHING")) {
			return current;
		}
		
		return null;
	}
	
	/*
	 * decide will determine what the agent does next
	 * whether that is suck, do nothing, or move up, down, left, or right
	 */
	public abstract String[] decide();
}
