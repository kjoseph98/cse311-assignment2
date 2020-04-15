package assignment2;

public class Question3 {

	public static void main(String[] args) {
		int[] popNums = new int[] {100/4, 100/4, 100/4, 100/4};
		
		// Question 3
		Simulation.runSimulation(100, 5, 10, 20, popNums).outputData("3a");
		Simulation.runSimulation(100, 5, 15, 20, popNums).outputData("3b");
		Simulation.runSimulation(100, 5, 20, 20, popNums).outputData("3c");
		Simulation.runSimulation(100, 5, 25, 20, popNums).outputData("3d");
		Simulation.runSimulation(100, 5, 30, 20, popNums).outputData("3e");

	}

}
