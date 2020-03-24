package assignment2;

public class GPlayer implements Player {

	int choice;
	int totalPayoff;

	public GPlayer() {
		this.choice = 0;
		this.totalPayoff = 0;
	}

	public int getChoice() {
		return choice;
	}
	
	public int getPayoff() {
		return totalPayoff;
	}

	public void addPayoff(int payoff) {
		this.totalPayoff += payoff;
	}

	public void updateChoice(int choice) {
		if (choice == 1) {			
			this.choice = 1;
		}
	}

	public void resetChoice() {
		this.choice = 0;
	}

}
