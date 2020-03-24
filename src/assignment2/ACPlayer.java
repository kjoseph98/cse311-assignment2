package assignment2;

public class ACPlayer implements Player {
	
	int totalPayoff;
	
	ACPlayer() {
		this.totalPayoff = 0;
	}
	
	public int getChoice() {
		return 0;
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
