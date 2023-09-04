package cs440.util;

import cs440.agent.Agent;
import cs440.agent.RandomAgent;
import cs440.agent.SmartAgent;

public class MainDriver {

	public static void main(String[] args) {
		
		FloorState start = new FloorState("0011010010101100110000011");
		FloorState goal =  new FloorState("0000000000000000000000000");
		
		Agent agent = new RandomAgent();
//		Agent agent = new SmartAgent();
		
		//configuring agent
		agent.setCoords(0, 0);
		agent.setCurrentState(start);
		agent.setGoalState(goal);
		
		FloorState current = start;
		current.setBot(agent);
		
		//displaying start state
		System.err.println(current.displayString());	
		
		String[] actions;
		int count = 0;		//total actions taken
		
		//Let the agent choose what to do until the floor is clean
		while(!current.isClean()) {
			
			actions = agent.decide();
			
			for(int i = 0 ; i < actions.length ; i++) {
				
				count++;	//tracking actions
				
				System.err.println(actions[i]);	//display the action
				
				// now use the action to generate the state in our
				// environment and display so we can see the puzzle
				// changing.
				try {
					
					current = agent.act(actions[i]);
					System.err.println(current.displayString());
				}
				catch (Exception e) {
					
					System.err.println("\n shit...");
					e.printStackTrace();
					System.exit(-1);
				}
				
			}
		}
		
		System.err.println("\n\nHoly shit it worked.");
		
		// TODO why state showing twice before action?
		// TODO what character to use to indicate bot on top of existing characters
	}

}
