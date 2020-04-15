package assignment2;

public class Question1 {

	public static void main(String[] args) {
		int[] popNums = new int[] {100/4, 100/4, 100/4, 100/4};
		
		// Question 1
		Simulation.runSimulation(100, 5, 5, 20, popNums).outputData("1");
	}

}
