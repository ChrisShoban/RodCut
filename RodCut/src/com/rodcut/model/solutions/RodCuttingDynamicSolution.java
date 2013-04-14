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
				possibilities.add(new Rod(rodList.get(index).getIndex(), 
										  rodList.get(index).getLength(), 
										  rodList.get(index).getPrice()));
			}
		}
	}
	
	@Override
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		// Similar to Knapsack, we make a list of possibilities to choose from which is large
		// than the total length of the rod (same as objects exceeding knapsack capacity)
		createNodePossibilities(rodList);
		
		int capacity = totalLength;
		int idCount = rodList.size();
		// generate a 2d array (table) with total length and object id's
		int[][] capacityById = new int[capacity][idCount];
		
		int currentLength = 0;
		
		// now we fill in the table to get the max revenue
		for(int length = 0; length < capacity; length++) {
			for(int id = 0; id < idCount; id++) {
				currentLength = rodList.get(id).getLength();
				if(currentLength <= length + 1) {
					capacityById[length][id] = currentLength; // this is not right, but it will be similar to this maybe ...
				}
			}
		}
		
		return null;
	}
}
