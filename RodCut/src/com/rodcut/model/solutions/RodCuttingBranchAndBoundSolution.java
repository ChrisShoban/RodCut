package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingBranchAndBoundSolution extends RodCuttingStrategy{

	private int totalLength = 0;
	//private int nodeCapacity = 0;
	private List<Rod> possibilities = new ArrayList<Rod>();
	//private List<String> discovered = new ArrayList<String>();
	
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		createNodePossibilities(rodList);
		this.totalLength = totalLength;
		int depth = 0;
		List<Rod> result = branch(0, possibilities, depth);
		return result;
	}
	
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
	
	/** Main recursive function for branching and ensuring each part is within the bounds set forward.
	 * @param pointer
	 * @param possibilitiesRemaining
	 * @return
	 */
	public List<Rod> branch(int pointer, List<Rod> possibilitiesRemaining, int depth) {
		if(withinBounds(pointer, possibilitiesRemaining)) { //&& !(discovered.contains(createId(currentRodList, possibilitiesLeft)))) {
			List<Rod> leftPossibilities = new ArrayList<Rod>(possibilitiesRemaining);
			List<Rod> rightPossibilities = new ArrayList<Rod>(possibilitiesRemaining);

			// Branching left means to keep the item at the pointer
			List<Rod> left = branch(pointer + 1, leftPossibilities, depth + 1);
			// create a new rodList without adding the next item to it

			// Branching right means to remove the item at the pointer
			rightPossibilities.remove(pointer);
			List<Rod> right = branch(pointer, rightPossibilities, depth + 1);
			// return the better of the left or the right
			List<Rod> result = greaterRevenue(left, right);
			if(result == null) {
				for(int i = pointer; i <= possibilitiesRemaining.size(); i++) {
					possibilitiesRemaining.remove(pointer);
				}
				return possibilitiesRemaining;
			}
			else 
				return result;
		}
		return null;
	}
	
	/**
	 * Used to determine which list has a greater revenue by comparing the sum of the profits of each list
	 * @param left the left list
	 * @param right the right list
	 * @return the list with a higher revenue
	 */
	public List<Rod> greaterRevenue(List<Rod> left, List<Rod> right) {
		if(left == null) {
			if(right == null) {
				return null;
			}
			return right;
		}
		else if(right == null) {
			return left;
		}
		else {
			int sumLeft = 0;
			int sumRight = 0;
			for(Rod rod : left) {
				sumLeft += rod.getPrice();
			}
			for(Rod rod : right) {
				sumRight += rod.getPrice();
			}
			
			if(sumLeft >= sumRight) {
				return left;
			}
			else {
				return right;
			}
		}
	}
	
	/**
	 * Make sure the sum of the lengths before our current "point" are no large than the total length feasible
	 * @param pointer every element before pointer is a valid element to consider keeping
	 * @param rodList is the current rod list node within the branch and bound tree
	 * @return true if the rod list length <= total length
	 */
	public boolean withinBounds(int pointer, List<Rod> rodList) {
		int currentLength = 0;
		for(int i = 0; i < pointer; i++) {
			currentLength += rodList.get(i).getLength();
		}
		return currentLength <= totalLength && pointer < rodList.size();
	}
	
	/**
	 * Ids will be saved to prevent duplicate sub-trees (another pruning technique used)
	 * @param rodList
	 * @return
	 */
	public String createId(List<Rod> currentRodList, List<Rod> possibilitiesLeft) {
		StringBuilder id = new StringBuilder();
		for(Rod rod : currentRodList) {
			id.append(rod.getIndex());
		}
		id.append(":");
		for(Rod rod : possibilitiesLeft) {
			id.append(rod.getIndex());
		}
		return id.toString();
	}
}
