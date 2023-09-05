package cs440.util;

import cs440.agent.Agent;
import cs440.agent.RandomAgent;
import cs440.agent.SmartAgent;

/**
 * Before you ask, yes this is a Maven FXML project
 * No, there is no GUI
 * What a good question, I do know why there's no GUI: I'm lazy
 * 
 * @author Rosey
 *
 */
public class MainDriver {

	public static void main(String[] args) {

		FloorState start = new FloorState("0011010010101100110000011");
		FloorState goal = new FloorState("0000000000000000000000000");

		Agent smartAgent = new SmartAgent();

		// configuring agent
		smartAgent.setCoords(0, 0);
		smartAgent.setCurrentState(start);
		smartAgent.setGoalState(goal);

		FloorState current1 = start;
		current1.setBot(smartAgent);

		// displaying start state
		System.err.println(current1.displayString());

		String[] smartActions;
		int smartCount = 0; // total actions taken

		// Let the agent choose what to do until the floor is clean
		while (!current1.isClean()) {

			smartActions = smartAgent.decide();

			for (int i = 0; i < smartActions.length; i++) {

				smartCount++; // tracking actions

				System.err.println(smartActions[i]); // display the action

				// now use the action to generate the state in our
				// environment and display so we can see the puzzle
				// changing.
				try {

					current1 = smartAgent.act(smartActions[i]);
					System.err.println(current1.displayString());
				} catch (Exception e) {

					System.err.println("\n shit...");
					e.printStackTrace();
					System.exit(-1);
				}

			}
		}

		System.err.println("\n\nSmart Agent Cleaned the Floor\n\n");
		

		// -------------------------------------Random Agent-------------------------------------//

		
		Agent randomAgent = new RandomAgent();
		FloorState current2 = new FloorState("0011010010101100110000011");

		randomAgent.setCoords(0, 0);
		randomAgent.setCurrentState(current2);
		randomAgent.setGoalState(goal);
		
		current2.setBot(randomAgent);

		// displaying start state
		System.err.println(current2.displayString());

		String[] randomActions;
		int randomCount = 0; // total actions taken

		// Let the agent choose what to do until the floor is clean
		while (!current2.isClean()) {

			randomActions = randomAgent.decide();

			for (int i = 0; i < randomActions.length; i++) {

				randomCount++; // tracking actions

				System.err.println(randomActions[i]); // display the action

				// now use the action to generate the state in our
				// environment and display so we can see the puzzle
				// changing.
				try {

					current2 = randomAgent.act(randomActions[i]);
					System.err.println(current2.displayString());
				} catch (Exception e) {

					System.err.println("\n oops...");
					e.printStackTrace();
					System.exit(-1);
				}

			}
		}

		System.err.println("\n\nRandom Agent Cleaned the Floor\n\n");

		System.out.println("Smart Agent\n-----------\nTotal Actions: " + smartCount);
		System.out.println("\n\nRandom Agent\n-----------\nTotal Actions: " + randomCount);
		
	}

}
