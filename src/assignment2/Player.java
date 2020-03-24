package assignment2;

public interface Player {
	
	int getChoice();
	
	int getPayoff();
	
	void addPayoff(int payoff);
	
	void updateChoice(int choice);
	
	void resetChoice();

}
