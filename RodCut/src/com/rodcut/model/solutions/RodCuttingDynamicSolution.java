package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingDynamicSolution extends RodCuttingStrategy{

	private int totalLength = 0;
	//private int nodeCapacity = 0;
	private List<Rod> possibilities = new ArrayList<Rod>();
	
	/**
	 * 
	 */
	public void createNodePossibilities(List<Rod> rodList) {
		int currLen = 0;
		totalLength = rodList.size();
		for(int index = 0; index < totalLength; index++) {
			currLen = rodList.get(index).getLength();
			for(int eachRod = 0; eachRod < totalLength/currLen; eachRod++) {
				possibilities.add(new Rod(rodList.get(index).getIndex() + eachRod, 
										  rodList.get(index).getLength(), 
										  rodList.get(index).getPrice()));
			}
		}
	}
	
	private void printTable(double[][] profits, int len, int id) {
		System.out.print("\t");
		for(int i = 1; i <= id; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < len; i++) {
			System.out.print(i + "\t");
			for(int j = 0; j < id; j++) {
				System.out.print(profits[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		// Similar to Knapsack, we make a list of possibilities to choose from which is large
		// than the total length of the rod (same as objects exceeding knapsack capacity)
		createNodePossibilities(rodList);
		
		//int capacity = totalLength;
		int idCount = possibilities.size();
		// generate a 2d array (table) with total length and object id's set to the profit totals
		double[][] profits = new double[idCount][totalLength];
		
		// now we fill in the table to get the max revenue
		for(int id = 0; id < idCount; id++) {
			for(int length = 0; length < totalLength; length++) {
				double price = possibilities.get(id).getPrice();
				profits[id][length] = maxProfit(id, length, price, possibilities, profits); // this is not right, but it will be similar to this maybe ...
			}
		}
		
		printTable(profits, idCount, totalLength);
		
		return null;
	}
	
	public double maxProfit(int jthObject, int currentLength, double profitJ, List<Rod> rods, double[][] table) {
		double tryToAddObject = 0;
		double dontTryToAddObject = 0;
		int currentRodLength = rods.get(jthObject).getLength();
		if(currentLength >= currentRodLength) {
			if(jthObject - 1 < 0) {
				jthObject = 2;
			}
			tryToAddObject = table[jthObject - 1][currentLength - rods.get(jthObject).getLength()] + profitJ;
		}
		else if(jthObject - 1 >= 0){
			dontTryToAddObject = table[jthObject - 1][currentLength];
		}
		
		if(tryToAddObject > dontTryToAddObject) {
			return tryToAddObject;
		}
		else {
			return dontTryToAddObject;
		}
	}
}
