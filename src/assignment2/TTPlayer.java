package assignment2;

public class TTPlayer implements Player {
	
	int choice;
	int totalPayoff;
	
	TTPlayer() {
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
		this.choice = choice;
	}
	
	public void resetChoice() {
		this.choice = 0;
	}

}
