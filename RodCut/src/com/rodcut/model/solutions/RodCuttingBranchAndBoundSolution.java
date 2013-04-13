package com.rodcut.model.solutions;

import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingBranchAndBoundSolution extends RodCuttingStrategy{

	@Override
	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	public void createNodePossibilities(List<Rod> rodList) {
		
	}
	
	public void createRootNode(List<Rod> rodList) {
		
	}
	
	public void branch() {
		// branch left
		// create new possibilities
		// calculate withinBound?
		// branch right
	}
	
	/**
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
	
	public static class Node {
		List<Rod> rodList;
		Node leftChild;
		Node rightChild;
	}
}
