package assignment2;

public class Question2 {
	
	public static void main(String[] args) {
		int[] popNums2a = new int[] {0, 33, 33, 34};
		int[] popNums2b = new int[] {10, 0, 80, 10};
		int[] popNums2c = new int[] {10, 10, 0, 80};
		
		// Question 2
		Simulation.runSimulation(100, 5, 5, 20, popNums2a).outputData("2a");
		Simulation.runSimulation(100, 5, 5, 20, popNums2b).outputData("2b");
		Simulation.runSimulation(100, 5, 5, 20, popNums2c).outputData("2c");
	}

}
