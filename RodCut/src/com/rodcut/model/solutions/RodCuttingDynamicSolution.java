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
		int priceListLength = rodList.size();
		for(int index = 0; index < priceListLength; index++) {
			currLen = rodList.get(index).getLength();
			for(int eachRod = 0; eachRod < totalLength/currLen; eachRod++) {
				possibilities.add(new Rod(rodList.get(index).getIndex() + eachRod, 
										  rodList.get(index).getLength(), 
										  rodList.get(index).getPrice()));
			}
		}
	}
	
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		this.totalLength = totalLength;
		// Similar to Knapsack, we make a list of possibilities to choose from which is large
		// than the total length of the rod (same as objects exceeding knapsack capacity)
		createNodePossibilities(rodList);
		
		//int capacity = totalLength;
		int idCount = possibilities.size();
		// generate a 2d array (table) with total length and object id's set to the profit totals
		double[][] profits = new double[idCount][totalLength + 1];
		
		// now we fill in the table to get the max revenue
		for(int id = 0; id < idCount; id++) {
			for(int length = 0; length <= totalLength; length++) {
				double price = possibilities.get(id).getPrice();
				profits[id][length] = maxProfit(id, length, price, possibilities, profits); // this is not right, but it will be similar to this maybe ...
			}
		}
		
		// Print Table
		//*
		System.out.print("\t");
		for(int len = 0; len <= totalLength; len++) {
			System.out.print(len + "\t");
		}
		System.out.println();
		for(int id = 0; id < idCount; id++) {
			System.out.print(id + "\t");
			for(int len = 0; len <= totalLength; len++) {
				System.out.print(profits[id][len] + "\t");
			}
			System.out.println();
		}
		//*/
		
		List<Rod> results = trackBack(profits, possibilities.size() - 1,totalLength, possibilities);
		
		return results;
	}
	
	private List<Rod> trackBack(double[][] profits, int idCount, int length, List<Rod> rods) {
		List<Rod> result = new ArrayList<Rod>();
		while(idCount > 0) {
			if(profits[idCount][length] != profits[idCount - 1][length]) {
				result.add(rods.get(idCount));
				length -= rods.get(idCount).getLength();
			}
			idCount--;
		}
		if(profits[idCount][length] > 0) {
			result.add(rods.get(idCount));
			length -= rods.get(idCount).getLength();
		}
		return result;
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
		if(jthObject - 1 >= 0){
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
