package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingBranchAndBoundSolution extends RodCuttingStrategy{

	private int nodeCapacity = 0;
	private List<Rod> possibilities = new ArrayList<Rod>();
	private List<String> discovered = new ArrayList<String>();
	
	
	@Override
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	public void createNodePossibilities(int totalLength, List<Rod> rodList) {
		int currLen = 0;
		for(int index = 0; index < totalLength; index++) {
			currLen = rodList.get(index).getLength();
			for(int eachRod = 0; eachRod < totalLength/currLen; eachRod++) {
				possibilities.add(new Rod(rodList.get(index).getIndex(), 
										  rodList.get(index).getLength(), 
										  rodList.get(index).getPrice()));
			}
			nodeCapacity += totalLength/currLen;
		}
	}
	
	public void startBranchBound(int totalLength, List<Rod> rodList) {
		int depth = 0;
		// create root
		// go left go right
		// pass rodList left for processing
		branch(totalLength, rodList, possibilities, depth);
		branch(totalLength, rodList, possibilities, depth);
	}
	
	public void branch(int totalLength, List<Rod> currentRodList, List<Rod> possibilitiesLeft, int depth) {
		if(withinBounds(totalLength, currentRodList) && !(discovered.contains(createId(currentRodList, possibilitiesLeft)))) {
			
			// create a new rodList adding the next item to it
			// branch left
			branch(totalLength, currentRodList, possibilitiesLeft, depth);
			// create a new rodList without adding the next item to it
			// branch right
			branch(totalLength, currentRodList, possibilitiesLeft, depth);
		}
	}
	
	/**
	 * length bounds are used for pruning the tree
	 * @param rodList is the current rod list node within the branch and bound tree
	 * @return true if the rod list length <= total length
	 */
	public boolean withinBounds(int totalLength, List<Rod> rodList) {
		int currentLength = 0;
		for(Rod rod : rodList) {
			currentLength += rod.getLength();
		}
		return currentLength <= totalLength;
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
	
	/**
	 * For testing ...
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Rod> list = new ArrayList<Rod>();
		for(int i = 1; i < 4; i++) {
			list.add(new Rod(i, i, i));
		}
		RodCuttingBranchAndBoundSolution test = new RodCuttingBranchAndBoundSolution();
		test.createNodePossibilities(list.size(), list);
	}
	
	public static class Node {
		int depth;
		List<Rod> rodList;
		
		Node parent;
		Node leftChild;
		Node rightChild;
		
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		public List<Rod> getRodList() {
			return rodList;
		}
		public void setRodList(List<Rod> rodList) {
			this.rodList = rodList;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public Node getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}
		public Node getRightChild() {
			return rightChild;
		}
		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}
}
