package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingBranchAndBoundSolution extends RodCuttingStrategy{

	private int totalLength = 0;
	private int nodeCapacity = 0;
	private List<Rod> possibilities = new ArrayList<Rod>();
	private List<String> discovered = new ArrayList<String>();
	
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		createNodePossibilities(rodList);
		this.totalLength = totalLength;
		// TODO Auto-generated method stub
		return null;
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
			nodeCapacity += totalLength/currLen;
		}
	}
	
	public List<Rod> startBranchBound(List<Rod> rodList) {
		int leftPointer = 0;
		int rightPointer = 0;
		List<Rod> leftPossibilities = new ArrayList<Rod>();
		List<Rod> rightPossibilities = new ArrayList<Rod>();
		Collections.copy(leftPossibilities, possibilities);
		Collections.copy(rightPossibilities, possibilities);
		// create root
		// go left go right
		// pass rodList left for processing
		List<Rod> left = branch(leftPointer, leftPossibilities);
		List<Rod> right = branch(rightPointer, rightPossibilities);
		return null;
	}
	
	public List<Rod> branch(int pointer, List<Rod> possibilitiesRemaining) {
		if(withinBounds(possibilitiesRemaining)) { //&& !(discovered.contains(createId(currentRodList, possibilitiesLeft)))) {
			List<Rod> leftPossibilities = new ArrayList<Rod>();
			List<Rod> rightPossibilities = new ArrayList<Rod>();
			Collections.copy(leftPossibilities, possibilitiesRemaining);
			Collections.copy(rightPossibilities, possibilitiesRemaining);
			// create a new rodList adding the next item to it
			// branch left
			List<Rod> left = branch(pointer + 1, possibilitiesRemaining);
			// create a new rodList without adding the next item to it
			// branch right
			List<Rod> right = branch(pointer, possibilitiesRemaining);
		}
		return null;
	}
	
	/**
	 * length bounds are used for pruning the tree
	 * @param rodList is the current rod list node within the branch and bound tree
	 * @return true if the rod list length <= total length
	 */
	public boolean withinBounds(List<Rod> rodList) {
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
		test.createNodePossibilities(list);
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
