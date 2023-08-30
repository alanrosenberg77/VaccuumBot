package cs440.util;

import cs440.agent.Agent;
import cs440.agent.RandomAgent;

public class MainDriver {

	public static void main(String[] args) {
		
		/*
		 * Give our agent a chance to think...make a plan.
		 */
		FloorState start = new FloorState("87654321*");
		FloorState goal =  new FloorState("12345678*");
		
		Agent agent = new RandomAgent();
		//Agent agent = new GreedyBestAgent();
		//Agent agent = new BfsAgent();
		
		agent.setStartState(start);
		agent.setGoalState(goal);
		
		System.err.println("Starting to plan....");
		Action actions = agent.decide();
		System.err.println("\n\n....ok.  I got it.\n\n");
		
		
		/*
		 * Now that our agent has a plan.  Let's see how
		 * it can be used.   We apply the plan, action by 
		 * action, hoping the results lead us to our intended
		 * goal state (a solved puzzle).
		 */
		FloorState current = start;
		System.err.println(current.displayString());	
		
		/*
		 * Iterate over each action in the plan....
		 */
		while(!current.isClean()) {
			System.err.println(actions);	//display the action
			
			// now use the action to generate the state in our
			// environment and display so we can see the puzzle
			// changing.
			try {
				current = current.nextStateFromAction(actions);
				System.err.println(current.displayString());
			}
			catch (Exception e) {
				System.err.println("\n shit...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		System.err.println("\n\nHoly shit it worked");
		
	}

}
