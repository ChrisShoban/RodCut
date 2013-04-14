package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingCommon;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingGreedySolution extends RodCuttingStrategy {

	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {

		// sort rods by price length ratio
		rodList = RodCuttingCommon.getInstance().sortByPriceLengthRatio(rodList);

		// greedy add rods until sum of selected rods length not > total length
		int currentLength = 0;
		int index = 0;
		List<Rod> selectedRods = new ArrayList<Rod>();
		while (index < rodList.size()) {
			Rod rod = rodList.get(index);
			if (rod.getLength() + currentLength <= totalLength) {
				selectedRods.add(new Rod(rod.getIndex(), rod.getLength(), rod.getPrice()));
				currentLength += rod.getLength();
			}
			else {
				index++;
			}
		}
		return selectedRods;
	}
	
	/**
	 * For testing ...
	 * @param args
	 */
	/**
	public static void main(String[] args) {
		ArrayList<Rod> list = new ArrayList<Rod>();
		for(int i = 1; i < 8; i++) {
				list.add(new Rod(i, i, i + 1));
		}
		RodCuttingGreedySolution test = new RodCuttingGreedySolution();
		test.getMaximumRevenueRods(list.size(), list);
	}
	*/
}