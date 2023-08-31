package cs440.util;

import cs440.agent.Agent;
import cs440.agent.RandomAgent;

public class MainDriver {

	public static void main(String[] args) {
		
		/*
		 * Give our agent a chance to think...make a plan.
		 */
		FloorState start = new FloorState("0011010010101100110000011");
		FloorState goal =  new FloorState("0000000000000000000000000");
		
		Agent agent = new RandomAgent();
		//Agent agent = new GreedyBestAgent();
		//Agent agent = new BfsAgent();
		
		agent.setCurrentState(start);
		agent.setGoalState(goal);
		
		/*
		 * Now that our agent has a plan.  Let's see how
		 * it can be used.   We apply the plan, action by 
		 * action, hoping the results lead us to our intended
		 * goal state (a solved puzzle).
		 */
		FloorState current = start;
		System.err.println(current.displayString());	
		
		Action action;
		
		/*
		 * Iterate over each action in the plan....
		 */
		while(!current.isClean()) {
			
			action = agent.decide();
			
			System.err.println(action);	//display the action
			
			// now use the action to generate the state in our
			// environment and display so we can see the puzzle
			// changing.
			try {
				
				current = current.nextStateFromAction(action);
				System.err.println(current.displayString());
			}
			catch (Exception e) {
				
				System.err.println("\n shit...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		System.err.println("\n\nHoly shit it worked.");
		
	}

}
