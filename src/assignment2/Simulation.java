package assignment2;

import java.util.*;

public class Simulation {

	private static int[][][] payoffMatrix = new int[][][] {{{3, 3}, {0, 5}}, {{5, 0}, {1, 1}}};

	public static void main(String[] args) {
		// Question 1
		runSimulation(100, 5, 5, 20).outputData(1);
		
		// Question 2
		
		
		// Question 3
		
		
	}
	/**
	 * 
	 * @param n
	 * @param m
	 * @param p
	 * @param k
	 * @return
	 */
	static SimulationData runSimulation(int n, int m, int p, int k) {
		SimulationData output = new SimulationData(k);
		int[] popNums = new int[] {n/4, n/4, n/4, n/4};

		for (int gen = 0; gen < k; gen++) {
			// Run Simulation
			Player[] players = createPopulation(n, popNums);
			runGeneration(n, players, m);
			
			// Shuffles array
			List<Player> playerList = Arrays.asList(players);
			Collections.shuffle(playerList);
			playerList.toArray(players);
			
			// Sorts array
			Arrays.sort(players, new Comparator<Player>() {
				@Override
				public int compare(Player one, Player two) {
					if (one.getPayoff() > two.getPayoff()) {
						return -1;
					} else if (one.getPayoff() < two.getPayoff()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			
			int[][] data = calcData(players, n, p);
			int[] payoffs = data[0];
			
			output.feedPercentages(calcPopPercentages(n, popNums), gen);
			output.feedPayoffs(payoffs, gen);
			output.feedAverages(calcAvgPayoffs(n, payoffs, popNums), gen);
			
			popNums = data[1];
		}
		
		return output;
	}

	/**
	 * 
	 * @param n
	 * @param popNums
	 * @return
	 */
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

	/**
	 * 
	 * @param n
	 * @param players
	 * @param rounds
	 */
	static void runGeneration(int n, Player[] players, int rounds) {
		for (int player1 = 0; player1 < n - 1; player1++) {
			for (int player2 = player1 + 1; player2 < n; player2++) {
				runGame(players[player1], players[player2], rounds);
			}
		}
	}

	/**
	 * 
	 * @param player1
	 * @param player2
	 * @param rounds
	 */
	static void runGame(Player player1, Player player2, int rounds) {
		for (int round = 0; round < rounds; round++) {
			runRound(player1, player2);	
		}
		
		player1.resetChoice();
		player2.resetChoice();
	}

	/**
	 * 
	 * @param player1
	 * @param player2
	 */
	static void runRound(Player player1, Player player2) {
		int choice1 = player1.getChoice();
		int choice2 = player2.getChoice();

		player1.addPayoff(payoffMatrix[choice1][choice2][0]);
		player2.addPayoff(payoffMatrix[choice1][choice2][1]);

		player1.updateChoice(choice2);
		player2.updateChoice(choice1);
	}
	
	/**
	 * 
	 * @param n
	 * @param popNums
	 * @return
	 */
	static int[] calcPopPercentages(int n, int[] popNums) {
		int[] percentages = new int[4];
		
		for (int i = 0; i < 4; i++) {
			percentages[i] = (int)(100 * ((double)popNums[i] / n));
		}
		
		return percentages;
	}
	
	/**
	 * 
	 * @param players
	 * @param n
	 * @param p
	 * @return
	 */
	static int[][] calcData(Player[] players, int n, int p) {
		int[][] data = new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}};
		int pPop = (int)(n * (p / 100.0));
		
		// Getting payoffs and replacing bottom p with top p
		for (int i = 0; i < n; i++) {
			Player player = players[i];
			if (player instanceof TTPlayer) {
				data[0][0] += player.getPayoff();
			} else if (player instanceof GPlayer) {
				data[0][1] += player.getPayoff();
			} else if (player instanceof ACPlayer) {
				data[0][2] += player.getPayoff();
			} else {
				data[0][3] += player.getPayoff();
			}
			
			if (i >= n - pPop) {
				player = players[n - 1 - i];
			}
			
			if (player instanceof TTPlayer) {
				data[1][0]++;
			} else if (player instanceof GPlayer) {
				data[1][1]++;
			} else if (player instanceof ACPlayer) {
				data[1][2]++;
			} else {
				data[1][3]++;
			}
		}
		
		return data;
	}
	
	/**
	 * 
	 * @param n
	 * @param payoffs
	 * @param popNums
	 * @return
	 */
	static double[] calcAvgPayoffs(int n, int[] payoffs, int[] popNums) {
		double[] avgs = new double[4];
		
		for (int i = 0; i < 4; i++) {
			if (popNums[i] != 0) {
				avgs[i] = (double)payoffs[i] / popNums[i];
			} else {
				avgs[i] = 0;
			}
		}
		
		return avgs;
	}

}
