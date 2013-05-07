package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingCommon;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingBranchAndBoundSolution extends RodCuttingStrategy{

	private int optimal = 0;
	private int totalLength = 0;
	//private int nodeCapacity = 0;
	private List<Rod> possibilities = new ArrayList<Rod>();
	//private List<String> discovered = new ArrayList<String>();
	
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		this.totalLength = totalLength;
		int depth = 0;
		createNodePossibilities(rodList);
		// SORT BY PRICE RATIO!!!
		possibilities = RodCuttingCommon.getInstance().sortByPriceLengthRatio(possibilities);
		List<Rod> result = branch(0, possibilities, depth, "root");
		return result;
	}
	
	/**
	 * 
	 */
	public void createNodePossibilities(List<Rod> rodList) {
		int currLen = 0;
		int priceListLength = rodList.size();
		for(int index = 0; index < priceListLength; index++) {
			currLen = rodList.get(index).getLength();
			for(int eachRod = 0; eachRod < totalLength/currLen; eachRod++) {
				possibilities.add(new Rod(rodList.get(index).getIndex(), 
										  rodList.get(index).getLength(), 
										  rodList.get(index).getPrice()));
			}
		}
	}
	
	// Adds the price of all the selected rods, then adds the remaining Rational Knapsack (Rational Length?) of
	// remaining possible rods ...
	private boolean isBetterThanOptimal(List<Rod> list, int pointer) {
		int currentOptimal = 0;
		int currentLength = 0;
		for(int i = 0; i < pointer; i++) {
			currentOptimal += list.get(i).getPrice();
			currentLength += list.get(i).getLength();
		}
		// TODO: Perform Greedy for the TEMP length
		// for everything after the pointer, perform Greedy Solution and get price for new ratio.
		RodCuttingGreedySolution greedy = new RodCuttingGreedySolution();
		List<Rod> rods = new ArrayList<Rod>();
		for(int i = pointer; i < list.size(); i++) {
			rods.add(list.get(i));
		}
		double rational = greedy.getMaximumRevenue(totalLength - currentLength, rods);
		return currentOptimal + rational > optimal;
	}
	
	/** Main recursive function for branching and ensuring each part is within the bounds set forward.
	 * @param pointer
	 * @param possibilitiesRemaining
	 * @return
	 */
	public List<Rod> branch(int pointer, List<Rod> possibilitiesRemaining, int depth, String text) {
		if(withinBounds(pointer, possibilitiesRemaining) && isBetterThanOptimal(possibilitiesRemaining, pointer)) {
			System.out.println("From " + text + " with pointer " + pointer + " and possibilities available of length ...");
			for(int i = 0; i < depth; i++) {
				System.out.print("-");
			}
			for(int i = 0; i < pointer; i++) {
				System.out.print(possibilitiesRemaining.get(i).getLength() + ", ");
			}
			System.out.println();
			List<Rod> leftPossibilities = new ArrayList<Rod>(possibilitiesRemaining);
			List<Rod> rightPossibilities = new ArrayList<Rod>(possibilitiesRemaining);

			// Branching left means to keep the item at the pointer
			List<Rod> left = branch(pointer + 1, leftPossibilities, depth + 1, "left");
			// create a new rodList without adding the next item to it

			// Branching right means to remove the item at the pointer
			rightPossibilities.remove(pointer);
			List<Rod> right = branch(pointer, rightPossibilities, depth + 1, "right");
			// return the better of the left or the right
			List<Rod> result = greaterRevenue(left, right);
			if(result == null) {
				for(int i = pointer; i <= possibilitiesRemaining.size(); i++) {
					possibilitiesRemaining.remove(pointer);
				}
				int potentialOptimal = 0;
				// For making the optimal checking bounding condition
				for(Rod rod: possibilitiesRemaining) {
					potentialOptimal += rod.getPrice();
				}
				if(potentialOptimal > optimal) {
					optimal = potentialOptimal;
				}
				return possibilitiesRemaining;
			}
			else 
				return result;
		}
		System.out.println("From " + text + " return null and back track");
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
	
	private static class Node{
		
		private int[] options;
		private Node left;
		private Node right;
		
		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}

		public Node(int size) {
			options = new int[size];
		}
		
		public void setOption(int index, int setting) {
			options[index] = setting;
		}
		
		public int getOption(int index) {
			return options[index];
		}
	}
	
	private List<Rod> branch(List<Rod> possibilies) {
		Node root = new Node(possibilities.size());
		return null;
	}
}
