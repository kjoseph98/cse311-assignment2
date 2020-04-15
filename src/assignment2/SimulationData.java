package assignment2;

import java.io.*;

public class SimulationData {
	
	int n, m, p, k;
	int[][] percentages;
	int[][] payoffs;
	double[][] avgPayoffs;
	int[] totalPayoff;
	
	public SimulationData(int n, int m, int p, int k) {
		this.n = n;
		this.m = m;
		this.p = p;
		this.k = k;
		this.percentages = new int[k][4];
		this.payoffs = new int[k][4];
		this.avgPayoffs = new double[k][4];
		this.totalPayoff = new int[k];
	}
	
	public void feedPercentages(int[] percentages, int gen) {
		this.percentages[gen] = percentages;
	}
	
	public void feedPayoffs(int[] payoffs, int gen) {
		this.payoffs[gen] = payoffs;
		
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.payoffs[gen][i] = payoffs[i];
			total += payoffs[i];
		}
		this.totalPayoff[gen] = total;
	}
	
	public void feedAverages(double[] avgPayoffs, int gen) {
		this.avgPayoffs[gen] = avgPayoffs;
	}
	
	public void outputData(String question) {
		printData(question);
		String path = "./outputs/question" + question + ".txt";
		createFile(path);
		try {
			PrintStream originalOut = System.out;
			PrintStream fileOut = new PrintStream(path);
			System.setOut(fileOut);
			
			System.out.println("Inputs:");
			System.out.println("n: " + n);
			System.out.println("m: " + m);
			System.out.println("p: " + p);
			System.out.println("k: " + k);
			System.out.println();
			
			System.out.println("Generation\tT4T%\tG%\tAC%\tAD%\tT4T Payoff\tG Payoff\tAC Payoff\tAD Payoff\tT4T Avg Payoff\tG Avg Payoff\tAC Avg Payoff\tAD Avg Payoff\tTotal Payoff");
			
			for (int gen = 0; gen < k; gen++) {
				System.out.print(gen + 1 + "\t");
				for (int percent : percentages[gen]) {
					System.out.print(percent + "\t");
				}
				for (int payoff : payoffs[gen]) {
					System.out.print(payoff + "\t");
				}
				for (double avg : payoffs[gen]) {
					System.out.print(avg + "\t");
				}
				System.out.print(totalPayoff[gen] + "\t\n");
			}
			
			System.setOut(originalOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void printData(String question) {
		System.out.println("Output for Simulation " + question + ":\n");
		System.out.println("Inputs:");
		System.out.println("n: " + n);
		System.out.println("m: " + m);
		System.out.println("p: " + p);
		System.out.println("k: " + k + "\n");
		
		for (int gen = 0; gen < this.k; gen++) {
			System.out.println("Gen " + (gen + 1) + ":\tT4T: " + percentages[gen][0] + "% G: " + percentages[gen][1] + "% AC: " + percentages[gen][2] + "% AD: " + percentages[gen][3] + "%");
			System.out.println("Gen " + (gen + 1) + ":\tT4T: " + payoffs[gen][0] + " G: " + payoffs[gen][1] + " AC: " + payoffs[gen][2] + " AD: " + payoffs[gen][3] + " Total: " + totalPayoff[gen]);
			System.out.println("Gen " + (gen + 1) + ":\tT4T: " + avgPayoffs[gen][0] + " G: " + avgPayoffs[gen][1] + " AC: " + avgPayoffs[gen][2] + " AD: " + avgPayoffs[gen][3]);
			System.out.println();
		}
	}
	
	public void createFile(String path) {
		try {
			File file = new File(path);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
