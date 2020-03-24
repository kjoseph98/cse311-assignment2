package assignment2;

public class Simulation {

	private static int[][][] payoffMatrix = new int[][][] {{{3, 3}, {0, 5}}, {{5, 0}, {1, 1}}};

	public static void main(String[] args) {
		runSimulation(100, 5, 0, 1);
		//		runSimulation(100, 5, 5, 20);
	}

	static void runSimulation(int n, int m, int p, int k) {
		int[] popNums = new int[] {n/4, n/4, n/4, n/4};
		
		Player[] players = createPopulation(n, popNums);

		for (int gen = 0; gen < k; gen++) {
			runGeneration(n, players, m);
			// Getting payoffs
			int ttPay = 0;
			int gPay = 0;
			int acPay = 0;
			int adPay = 0;
			for (Player player : players) {
				if(player instanceof TTPlayer) {
					ttPay += player.getPayoff();
				} else if (player instanceof GPlayer) {
					gPay += player.getPayoff();
				} else if (player instanceof ACPlayer) {
					acPay += player.getPayoff();
				} else {
					adPay += player.getPayoff();
				}
			}
			System.out.println("TT Player: " + ttPay);
			System.out.println("G Player: " + gPay);
			System.out.println("AC Player: " + acPay);
			System.out.println("AD Player: " + adPay);
			// Rank players
			// Take out players
			// Add new players
		}
	}

	static Player[] createPopulation(int n, int[] popNums) {
		Player[] players = new Player[n];
		int player = 0;

		for (int tt = 0; tt < popNums[0]; tt++) {
			players[player] = new TTPlayer();
			player++;
		}
		
		for (int g = 0; g < popNums[1]; g++) {
			players[player] = new GPlayer();
			player++;
		}
		
		for (int ac = 0; ac < popNums[2]; ac++) {
			players[player] = new ACPlayer();
			player++;
		}
		
		for (int ad = 0; ad < popNums[3]; ad++) {
			players[player] = new ADPlayer();
			player++;
		}
		
		return players;
	}

	static void runGeneration(int n, Player[] players, int rounds) {
		for (int player1 = 0; player1 < n - 1; player1++) {
			for (int player2 = player1 + 1; player2 < n; player2++) {
				runGame(players[player1], players[player2], rounds);
			}
		}
	}

	static void runGame(Player player1, Player player2, int rounds) {
		for (int round = 0; round < rounds; round++) {
			runRound(player1, player2);	
		}
		
		player1.resetChoice();
		player2.resetChoice();
	}

	static void runRound(Player player1, Player player2) {
		int choice1 = player1.getChoice();
		int choice2 = player2.getChoice();

		player1.addPayoff(payoffMatrix[choice1][choice2][0]);
		player2.addPayoff(payoffMatrix[choice1][choice2][1]);

		player1.updateChoice(choice2);
		player2.updateChoice(choice1);
	}

}
