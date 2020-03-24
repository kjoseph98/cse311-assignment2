package assignment2;

public class ADPlayer implements Player {

	int totalPayoff;

	ADPlayer() {
		this.totalPayoff = 0;
	}

	public int getChoice() {
		return 1;
	}
	
	public int getPayoff() {
		return totalPayoff;
	}

	public void addPayoff(int payoff) {
		this.totalPayoff += payoff;
	}

	public void updateChoice(int choice) {
		return ;
	}

	public void resetChoice() {
		return ;
	}

}
